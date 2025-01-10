package com.example.gateway.ApiGateway.config;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2LoginSpec;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity security) {
		
		security
				.authorizeExchange(exchange->exchange
						.anyExchange().authenticated()
						)
//				.oauth2Login(oauth2 -> oauth2
//                        .authenticationSuccessHandler(customSuccessHandler())
//                )
				.oauth2Login()
				.and()
				.oauth2ResourceServer()
				.jwt();
		
		return security.build();
		
	}
	
	  @Bean
	    public ServerAuthenticationSuccessHandler customSuccessHandler() {
	        return (webFilterExchange, authentication) -> {
	            var response = webFilterExchange.getExchange().getResponse();
	            response.setStatusCode(HttpStatus.FOUND);
	            response.getHeaders().setLocation(URI.create("http://localhost:9093/auth/login"));
	            return response.setComplete();
	        };
	    }
	
}
