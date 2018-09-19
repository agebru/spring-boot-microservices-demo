package om.mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import org.mockito.MockitoAnnotations;

import om.mockito.IProductService;
import om.mockito.ProductInformaionService;

public class TestItemService {
	
	@Mock
	private IProductService productService;
	
	private ProductInformaionService productInformaionService;
	
	@Before
	public void init() {
		productInformaionService=new ProductInformaionService();		
		MockitoAnnotations.initMocks(productService);
	}
	
	
	
	
	@Test
	public void testDoubleItemPrices() {	
		when(productService.getTotalItemPrice()).thenReturn(500.50);
		
		double TotalItemPrice=productInformaionService.DoubleItemPrices();
		assertEquals(TotalItemPrice, 180.9);
		
		
		
	}

}
