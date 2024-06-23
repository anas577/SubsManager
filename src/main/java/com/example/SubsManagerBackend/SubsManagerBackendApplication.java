package com.example.SubsManagerBackend;

import com.example.SubsManagerBackend.dao.entities.*;
import com.example.SubsManagerBackend.service.CategoryManager;
import com.example.SubsManagerBackend.service.ProviderManager;
import com.example.SubsManagerBackend.service.SubscriptionManager;
import com.example.SubsManagerBackend.service.UserManager;
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
	public static void main(String[] args) {
		SpringApplication.run(SubsManagerBackendApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	//@PostConstruct
	public void initUsers() {

		userManager.addUser( new User(null,"user3", "123","user2@mail.com", Role.USER,null));
		userManager.addUser(new User(null,"admin3", "123","admin2@mail.com", Role.ADMIN,null));



	}




}
