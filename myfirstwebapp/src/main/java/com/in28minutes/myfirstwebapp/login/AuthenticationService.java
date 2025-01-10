package com.in28minutes.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String name,String password) {
		
		boolean isValidUsername=name.equalsIgnoreCase("Prabhat Sharma");
		boolean isValidPassword=password.equalsIgnoreCase("password");
		
		return isValidUsername && isValidPassword;
	}
	
}
