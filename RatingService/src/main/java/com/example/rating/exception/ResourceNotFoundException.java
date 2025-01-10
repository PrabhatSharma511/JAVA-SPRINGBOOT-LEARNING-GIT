package com.example.rating.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException() {
		super("not found");
	}
	
	public ResourceNotFoundException(String s) {
		super(s);
	}

}
