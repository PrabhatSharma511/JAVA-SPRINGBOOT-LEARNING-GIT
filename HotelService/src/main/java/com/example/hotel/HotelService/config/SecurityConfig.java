package com.example.hotel.HotelService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		
		security
				.authorizeHttpRequests(authorize->authorize.anyRequest().authenticated())
				.oauth2ResourceServer((oauth2) -> 
	            oauth2.jwt()
	        );		
		return security.build();
		
	}
	
}