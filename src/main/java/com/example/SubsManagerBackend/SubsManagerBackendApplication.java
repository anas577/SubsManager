package com.example.SubsManagerBackend;

import com.example.SubsManagerBackend.dao.entities.*;
import com.example.SubsManagerBackend.service.CategoryManager;
import com.example.SubsManagerBackend.service.ProviderManager;
import com.example.SubsManagerBackend.service.SubscriptionManager;
import com.example.SubsManagerBackend.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class SubsManagerBackendApplication {
	@Autowired
	CategoryManager categoryManager;

	@Autowired
	ProviderManager providerManager;

	@Autowired
	UserManager userManager;

	@Autowired
	SubscriptionManager subscriptionManager;
	public static void main(String[] args) {
		SpringApplication.run(SubsManagerBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
            categoryManager.addCategory(new Category(null,"Streaming","ddd",null));
            categoryManager.addCategory(new Category(null,"Fitness","ddd",null));
			Category cat = categoryManager.getCategoryById(1);
			Category cat2 = categoryManager.getCategoryById(2);


			Provider provider = new Provider();
			provider.setName("Netflix");
			provider.setCategory(cat);
			providerManager.addProvider(provider);

			Provider provider2 = new Provider();
			provider2.setName("Hulu");
			provider2.setCategory(cat);
			providerManager.addProvider(provider2);

			Provider provider3 = new Provider();
			provider3.setName("Amazon Prime");
			provider3.setCategory(cat);
			providerManager.addProvider(provider3);

			Provider provider4 = new Provider();
			provider4.setName("My Fitness Pal");
			provider4.setCategory(cat2);
			providerManager.addProvider(provider4);

			User user = new User(null, "TestUSer","test.email@gmail.com",null);
			userManager.addUser(user);


            LocalDate localDate = LocalDate.of(2024, 5, 19); // Year 2024, Month May, Day 19
            Date startDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

			Subscription subscription = new Subscription(null,"Standard", SubscriptionStatus.ACTIVE,RenewalFrequency.MONTHLY,startDate,12,userManager.getUserById(1),providerManager.getProviderById(1),null,null,null);
			subscriptionManager.addSubscription(subscription);
		};
	}

}
