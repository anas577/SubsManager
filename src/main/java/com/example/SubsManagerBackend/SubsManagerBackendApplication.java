package com.example.SubsManagerBackend;

import com.example.SubsManagerBackend.dao.entities.Category;
import com.example.SubsManagerBackend.dao.entities.Provider;
import com.example.SubsManagerBackend.service.CategoryManager;
import com.example.SubsManagerBackend.service.ProviderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SubsManagerBackendApplication {
	@Autowired
	CategoryManager categoryManager;

	@Autowired
	ProviderManager providerManager;
	public static void main(String[] args) {
		SpringApplication.run(SubsManagerBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			/*Category cat = categoryManager.getCategoryById(5);
			Category cat2 = categoryManager.getCategoryById(6);


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
			providerManager.addProvider(provider4);*/





		};
	}

}
