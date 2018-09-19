package com.javacodegeeks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceJUnitRunnerTest {
	
	private MyService myService;
	
	@Mock
	private MyDao myDao;
	
	@Test
	public void testFindById() {
		myService = new MyService(myDao);
		myService.findById(1L);
		Mockito.verify(myDao).findById(1L);
		
	}

}
