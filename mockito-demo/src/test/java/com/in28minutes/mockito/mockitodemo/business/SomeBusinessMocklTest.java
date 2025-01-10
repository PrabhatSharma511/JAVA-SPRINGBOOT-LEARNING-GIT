package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMocklTest {
	
	// @ExtendWith annotation allows to replace @Mock and @InjectMocks with real mocks
	
	@Mock
	private DataService dataService;
	
	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;

	@Test
	void test() {
//		DataService dataService = mock(DataService.class);
		when(dataService.retrieveAllData()).thenReturn(new int[] {34,23,45,12,89});

//		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataMock);
		int greatest = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(89,greatest);
	}
	
	@Test
	void test1() {
		when(dataService.retrieveAllData()).thenReturn(new int[] {});
		int greatest = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(Integer.MIN_VALUE, greatest);
	}
	
	@Test
	void test2() {
		DataService dataMock = mock(DataService.class);
		when(dataMock.retrieveAllData()).thenReturn(new int[] {34,23});

		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataMock);
		int greatest = businessImpl.findTheGreatestFromAllData();
		assertEquals(34,greatest);
	}
	

}
