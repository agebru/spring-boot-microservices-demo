package com.javacodegeeks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MyServiceRuleTest {
	
	@Mock
	private MyDao myDao;
	
	/*@Rule 
	public MockitoRule rule = MockitoJUnit.rule();
	*/
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		MyService myService = new MyService(myDao);
		Mockito.when(myDao.findById(1L)).thenReturn(createTestEntity());
		MyEntity actual = myService.findById(1L);
		Assert.assertEquals("Amanuel", actual.getFirstName());
		Assert.assertEquals("Gebru", actual.getSurname());
		Mockito.verify(myDao).findById(1L);
	}
	
	private MyEntity createTestEntity() {
		MyEntity myEntity = new MyEntity();
		myEntity.setFirstName("Amanuel");
		myEntity.setSurname("Gebru");
		return myEntity;
	}

}
