package com.in28minutes.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;


@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount=0;
	static {
		todos.add(new Todo(++todosCount,"in28minutes","Learn Spring Boot",LocalDate.now().plusMonths(1),false));
		todos.add(new Todo(++todosCount,"in28minutes","Learn React Now",LocalDate.now().plusMonths(2),false));
		todos.add(new Todo(++todosCount,"in28minutes","make resume ",LocalDate.now().plusMonths(2),false));
		todos.add(new Todo(++todosCount,"Prabhat","Complete Spring Course",LocalDate.now().plusMonths(1),false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<Todo> predicate = todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description,LocalDate target,boolean done) {
		Todo todo = new Todo(++todosCount,username,description,target,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<Todo> predicate = todo->todo.getId()==id;
		todos.removeIf(predicate);
		
	}

	public Todo findById(int id) {
		Predicate<Todo> predicate = todo->todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
	
}