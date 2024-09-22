package com.example.Test_Employee_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TestEmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestEmployeeManagementApplication.class, args);
	}

}