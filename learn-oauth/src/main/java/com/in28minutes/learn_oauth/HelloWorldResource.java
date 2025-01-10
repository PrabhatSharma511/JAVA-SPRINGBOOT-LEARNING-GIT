package com.in28minutes.learn_oauth;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	@GetMapping("/")
	public String hello(Authentication auth) {
		System.out.println(auth);
		return "Hello Google Login";
	}
	
}
