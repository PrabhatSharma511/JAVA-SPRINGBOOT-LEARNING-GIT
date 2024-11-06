package com.example.okta_again;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OktaAgainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OktaAgainApplication.class, args);
	}
	
	@GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		System.out.print(principal);
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

}
