package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {
	
	//filter chain
	//authenticate all requests
	//basic auth
	//disable csrf
	//stateles rest api i.e without session
	//we can remove http from all except first one and chain them all as http supports chaining
	//access to preflight request with OPTIONS
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth->auth.antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated()
				);
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(
				session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
		http.csrf().disable();
		return http.build();
	}

}
