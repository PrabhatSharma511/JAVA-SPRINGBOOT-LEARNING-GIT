package com.example.user.service.service;

import java.util.List;

import com.example.user.service.entities.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
}
