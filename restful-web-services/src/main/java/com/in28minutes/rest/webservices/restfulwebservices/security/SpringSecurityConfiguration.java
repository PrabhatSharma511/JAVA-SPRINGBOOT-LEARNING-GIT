package com.in28minutes.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//1. All request should be authenticated
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated()
				);
		//2. If not authenticated a web page/popup is shown httpBasic configures http basic authentication
		http.httpBasic(withDefaults());
		
		
		//3. csrf-> put post wont work without disabling this
		http.csrf().disable();
		
		return http.build();
	}
	
}
