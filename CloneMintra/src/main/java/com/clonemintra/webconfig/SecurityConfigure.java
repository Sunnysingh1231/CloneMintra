package com.clonemintra.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import logging.level.org.springframework.security=DEBUG

@Configuration
@EnableWebSecurity
public class SecurityConfigure {

//	@Bean
//	public SecurityFilterChain userSecurityFilterChain(HttpSecurity http) throws Exception {
//		
//		http.authorizeHttpRequests(
//				auth -> auth.requestMatchers(HttpMethod.GET, "findallusers").permitAll()
////				.requestMatchers( "/findallusers")
////				.hasAnyRole("ADMIN")
////				.permitAll()
//				.anyRequest().authenticated())
//		.csrf(c -> c.disable())
//		.formLogin(Customizer.withDefaults())
//		.httpBasic(Customizer.withDefaults());
//		
//		return http.build();
//	}

//	@Bean
//	public SecurityFilterChain userSecurityFilterChain(HttpSecurity http) throws Exception {
//	    return http
//	    	.authorizeHttpRequests(auth -> auth
//	        .requestMatchers(HttpMethod.GET, "/findallusers").permitAll()  // Add forward slash before 'findallusers'
//	        .anyRequest().authenticated())
////				;
//	        .csrf(csrf -> csrf.disable()) // Disabling CSRF for simplicity; consider enabling it for production
//	        .formLogin(Customizer.withDefaults())
//	        .httpBasic(Customizer.withDefaults())
////				;
//
//	    .build();
//	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
