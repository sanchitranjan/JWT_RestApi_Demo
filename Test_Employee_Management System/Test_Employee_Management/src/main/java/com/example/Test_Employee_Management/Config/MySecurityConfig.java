package com.example.Test_Employee_Management.Config;

import com.example.Test_Employee_Management.Security.JwtAuthenticationEntryPoint;
import com.example.Test_Employee_Management.Security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint point;

	@Autowired
	private JwtAuthenticationFilter filter;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/employees/**").authenticated()
													.requestMatchers("/api/v1/employees").permitAll()
													.requestMatchers("/auth/login").permitAll()
													.requestMatchers("/auth/create-user").permitAll()
													.requestMatchers("/api-docs").permitAll()
													.requestMatchers("/swagger-resources/**").permitAll()
													.requestMatchers("/swagger-ui/index.html").permitAll()
													.requestMatchers("/webjars/**").permitAll()
													.anyRequest().authenticated())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		return daoAuthenticationProvider;
	}

}


	//authentication
//	@Bean
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








//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        return http
//            .csrf(csrf-> csrf.disable())
//            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                    .requestMatchers(HttpMethod.GET, "http://localhost:8081/api/v1/employees").permitAll()
//                    .requestMatchers("/api/v1/employees/**").authenticated()
//                    .anyRequest().permitAll()
//            )
//            .build();


//		return http.csrf().disable().authorizeHttpRequests(authorizeRequests ->
//	                authorizeRequests.requestMatchers("/api/v1/employees").permitAll()
//	                .requestMatchers("/api/v1/employees/**").authenticated())
//				.build();


//		return http.csrf().disable()
//					.authorizeHttpRequests()
//					.requestMatchers("/api/v1/employees")
//					.permitAll()
//					.and()
//					.authorizeHttpRequests()
//					.requestMatchers("/api/v1/employees/**")
//					.authenticated()
//					.build();
//	}
//
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
