package com.example.SubsManagerBackend;

import com.example.SubsManagerBackend.dao.entities.*;
import com.example.SubsManagerBackend.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class SubsManagerBackendApplication {
	@Autowired
	private UserManager userManager;
	@Autowired
	private CategoryManager categoryManager;
	@Autowired
	private ProviderManager providerManager;
	@Autowired
	private SubscriptionManager subscriptionManager;
	@Autowired
	private PaymentManager paymentManager;
	public static void main(String[] args) {
		SpringApplication.run(SubsManagerBackendApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@PostConstruct
	public void init() {
		//userManager.addUser( new User(null,"anas", "anasfathani","anas.fathani@outlook.com", Role.USER,null));
		/* userManager.addUser( new User(null,"user3", "123","user2@mail.com", Role.USER,null));
		userManager.addUser(new User(null,"admin3", "123","admin2@mail.com", Role.ADMIN,null));
		Category streamingCategory = new Category(null,"Streaming","Streaming services such as movies and TV shows.",null);
		Category fitnessCategory = new Category(null,"Fitness","Fitness and health services",null);
		Category productivityCategory = new Category(null,"Productivity","Productivity and work-related services.",null);
		categoryManager.addCategory(streamingCategory);
		categoryManager.addCategory(fitnessCategory);
		categoryManager.addCategory(productivityCategory);

		providerManager.addProvider(new Provider(null,"Netflix","https://1000logos.net/wp-content/uploads/2017/05/Netflix-Logo-2006.png",null,streamingCategory,null));
		providerManager.addProvider(new Provider(null,"Hulu","https://1000logos.net/wp-content/uploads/2020/12/Hulu-Logo.jpg",null,streamingCategory,null));
		providerManager.addProvider(new Provider(null,"Amazon Prime Video","https://1000logos.net/wp-content/uploads/2022/10/Amazon-Prime-Video-Icon.png",null,streamingCategory,null));
		providerManager.addProvider(new Provider(null,"Disney+","https://1000logos.net/wp-content/uploads/2021/01/Disney-Plus-Logo-768x432.jpg",null,streamingCategory,null));
		providerManager.addProvider(new Provider(null,"Apple TV+","https://1000logos.net/wp-content/uploads/2022/02/Apple-TV-macOS-logo-768x432.png",null,streamingCategory,null));
		providerManager.addProvider(new Provider(null,"MyfitnessPal","https://www.pngwing.com/en/free-png-yhbfa",null,streamingCategory,null));
		providerManager.addProvider(new Provider(null,"Fitbit","https://1000logos.net/wp-content/uploads/2017/09/Fitbit-logo-768x384.jpg",null,streamingCategory,null));
		providerManager.addProvider(new Provider(null,"ChatGPT","https://1000logos.net/wp-content/uploads/2023/02/ChatGPT-Logo-768x432.jpg",null,streamingCategory,null));
		providerManager.addProvider(new Provider(null,"Trello","https://1000logos.net/wp-content/uploads/2021/05/Trello-logo-768x432.jpg",null,streamingCategory,null));*/

		//subscriptionManager.addSubscription(new Subscription(null,"Family", SubscriptionStatus.ACTIVE,RenewalFrequency.MONTHLY, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 12.0,userManager.getUserById(22),providerManager.getProviderById(56),null,null,null));
		//subscriptionManager.addSubscription(new Subscription(null,"Pro", SubscriptionStatus.ACTIVE,RenewalFrequency.MONTHLY, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 20.0,userManager.getUserById(22),providerManager.getProviderById(62),null,null,null));

		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 10,subscriptionManager.getSubscriptionById(7) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 10,subscriptionManager.getSubscriptionById(7) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 10,subscriptionManager.getSubscriptionById(7) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 12,subscriptionManager.getSubscriptionById(12) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 12,subscriptionManager.getSubscriptionById(12) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 12,subscriptionManager.getSubscriptionById(12) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 12,subscriptionManager.getSubscriptionById(12) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 20,subscriptionManager.getSubscriptionById(13) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 20,subscriptionManager.getSubscriptionById(13) ));
		paymentManager.addPayment(new Payment(null, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 20,subscriptionManager.getSubscriptionById(13) ));


	}




}
