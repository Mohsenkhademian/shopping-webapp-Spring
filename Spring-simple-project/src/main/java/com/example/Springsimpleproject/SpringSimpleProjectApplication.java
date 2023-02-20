package com.example.Springsimpleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringSimpleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSimpleProjectApplication.class, args);
	}

}
