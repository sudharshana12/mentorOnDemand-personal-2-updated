package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.example.models"})  // scan JPA entities manually
public class MentorDemandApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorDemandApplication.class, args);
	}

}
