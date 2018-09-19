package om.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.Test;

public class MockTestDemo {
	
	@Test
	public void testMockLinkedList() {
		
		LinkedList<Integer> mockLinkedList=mock(LinkedList.class);
		
		when(mockLinkedList.get(0)).thenReturn(20);
		when(mockLinkedList.get(1)).thenReturn(30);
		when(mockLinkedList.get(2)).thenReturn(40);
		
		int sum=0;
		for(int i=0;i<3;i++) {
			sum+=mockLinkedList.get(i);
		}
				int doubleSome=2*sum;
		
		assertEquals(doubleSome, 180);
		
	}

}
