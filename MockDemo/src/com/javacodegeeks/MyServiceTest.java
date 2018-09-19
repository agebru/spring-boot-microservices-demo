package com.javacodegeeks;

import static org.mockito.Mockito.mock;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MyServiceTest {

	
	@Mock
	private MyDao myDao;	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		System.out.println("Initialize all your mock object here!");
		
	}
	
	@Test
	public void testFindById() {
		//MockitoAnnotations.initMocks(this);// initialize the mock object
		//myDao=mock(MyDao.class);
		MyService myService = new MyService(myDao);
		myService.findById(1L);
		Mockito.verify(myDao);
		
	}
	
	@Test
	public void testMock() {
		// Mock
		LinkedList mocklinkedList = Mockito.mock(LinkedList.class);
		// Stub
		Mockito.when(mocklinkedList.get(0)).thenReturn("First Value");
		// Verify
		Assert.assertEquals("First Value", mocklinkedList.get(0));
		Mockito.verify(mocklinkedList).get(0);
	}

}
