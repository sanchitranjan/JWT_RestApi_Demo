package com.example.Test_Employee_Management.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

//    @Bean
//	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		UserDetails user1 = User.builder().username("Sanchit")
//								.password(encoder.encode("Password1"))
//								.roles("ADMIN")
//								.build();
//
//		UserDetails user2 = User.builder().username("John")
//								.password(encoder.encode("Password2"))
//								.roles("USER")
//								.build();
//
//		return new InMemoryUserDetailsManager(user1, user2);
//	}

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
