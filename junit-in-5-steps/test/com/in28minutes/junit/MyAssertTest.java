package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	List<String> todos = Arrays.asList("AWS","JAVA","REACT");

	@Test
	void test() {
		boolean test = todos.contains("AWS");
		assertEquals(true, test);
		assertTrue(test);//chekcs if the returned value is true also there is assertFalse, assertNull etc
		assertArrayEquals(new int[] {1,2}, new int[] {1,2}); //checks if two arrays are equal
		assertEquals(3, todos.size(),"Something went wrong");
	}

}
