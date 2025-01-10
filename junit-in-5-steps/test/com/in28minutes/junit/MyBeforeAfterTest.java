package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All");
	}
	
	@Test
	void test1() {
		System.out.println("test1");
	}
	
	@Test
	void test2() {
		System.out.println("test2");
	}
	
	@Test
	void test3() {
		System.out.println("test3");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("before each");
	}
	@AfterEach
	void AfterEach() {
		System.out.println("After each");
	}
	
	@org.junit.jupiter.api.AfterAll
	static void AfterAll() {
		System.out.println("After All");
	}

}
