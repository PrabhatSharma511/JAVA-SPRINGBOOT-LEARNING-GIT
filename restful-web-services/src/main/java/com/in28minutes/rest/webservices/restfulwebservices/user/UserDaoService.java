package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount,"Prabhat Sharma",LocalDate.now().minusYears(25).minusMonths(9)));
		users.add(new User(++userCount,"Adam",LocalDate.now().minusYears(30).minusMonths(2)));
		users.add(new User(++userCount,"Eve",LocalDate.now().minusYears(20).minusMonths(6)));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<User> predicate = user->user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User addUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<User> predicate = user->user.getId().equals(id);
		users.removeIf(predicate);
	}
	
}
