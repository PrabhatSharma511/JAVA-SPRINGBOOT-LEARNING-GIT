package com.in28minutes.mockito.mockitodemo.list;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void simpleTest() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(3);
		assertEquals(3, mockList.size());
	}
	
	@Test
	void multipleReturns() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(3).thenReturn(2).thenReturn(1);
		assertEquals(3, mockList.size());
		assertEquals(2, mockList.size());
		assertEquals(1, mockList.size());
		assertEquals(1, mockList.size());
		assertEquals(1, mockList.size());
	}
	
	
	@Test
	void specificParameters() {
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn("Some 0 val");
		assertEquals("Some 0 val", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	
	@Test
	void genericParameters() {
		List mockList = mock(List.class);
		when(mockList.get(Mockito.anyInt())).thenReturn("Some String");
		assertEquals("Some String", mockList.get(0));
		assertEquals("Some String", mockList.get(1));
	}

}
