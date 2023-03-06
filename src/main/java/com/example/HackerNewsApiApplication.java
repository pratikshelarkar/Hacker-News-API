package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@EnableCaching
public class HackerNewsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackerNewsApiApplication.class, args);
		
	}
}