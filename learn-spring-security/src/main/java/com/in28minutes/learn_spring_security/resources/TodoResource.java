package com.in28minutes.learn_spring_security.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class TodoResource {
	Logger logger = LoggerFactory.getLogger(getClass());

	private static final List<Todo> TODO_LIST = List.of(new Todo("in28minutes","learn JAVA"),new Todo("prabhat","Learn React"));

	//only users with admin role can access this method/api
	@RolesAllowed("ADMIN")
	@GetMapping("/todos")
	public List<Todo> retrieveTodos() {
		return TODO_LIST;
	}
	
	//@Secured check against authorities
	//@Pre/@Post checks against roles
	
	@GetMapping("/users/{username}/todo")
	@PreAuthorize("hasRole('USER') and #username == authentication.name")
	@PostAuthorize("returnObject.username == 'in28minutes'")
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public Todo rerieveTodoForSpecificUser(@PathVariable("username") String username) {
		return TODO_LIST.stream().filter(todo->todo.username().equals(username)).findFirst().orElse(null);
	}
	
	@PostMapping("/users/{username}/todo")
	public void createTodoForSpecificUser(@PathVariable("username") String username,@RequestBody Todo todo) {
		logger.info("create {} for {} ",todo,username);
	}
	
	
}

record Todo(String username,String description) {}
