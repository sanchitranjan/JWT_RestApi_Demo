package com.example.manager_microservice.manager_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class                                                                                                               ManagerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerMicroserviceApplication.class, args);
	}

	@Bean
	public RestTemplate getBeanRestTemplate() {
		return new RestTemplate();
	}
	
}
