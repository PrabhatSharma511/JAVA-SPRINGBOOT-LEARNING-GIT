package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessStubTest {

	@Test
	void test() {
		DataServiceStub dataServiceStub = new DataServiceStub();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
		int greatest = businessImpl.findTheGreatestFromAllData();
		assertEquals(99,greatest);
	}
	
	@Test
	void test2() {
		DataServiceStub2 dataServiceStub2 = new DataServiceStub2();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub2);
		int greatest = businessImpl.findTheGreatestFromAllData();
		assertEquals(34,greatest);
	}

}


class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {25,34,53,67,99};
	}
}

class DataServiceStub2 implements DataService{

	@Override
	public int[] retrieveAllData() {
		
		return new int[] {34};
	}
	
}