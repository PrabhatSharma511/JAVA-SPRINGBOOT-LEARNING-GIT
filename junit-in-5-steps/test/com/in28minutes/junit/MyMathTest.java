package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	


	@Test
	void test() {
//		fail("Not yet implemented");
		int[] arr = {1,2,3,4,5};
		MyMath math = new MyMath();
		int result = math.calculateSum(arr);
		System.out.println(result);
		int expectedResult = 15;
		assertEquals(expectedResult, result);
		
	}
	
	@Test
	void test1() {
//		fail("Not yet implemented");
		int[] arr = {};
		MyMath math = new MyMath();
		int result = math.calculateSum(arr);
		System.out.println(result);
		int expectedResult = 0;
		assertEquals(expectedResult, result);
		
	}

}
