package om.mockito;

import java.util.List;

public class ProductInformaionService {

	private IProductService productService;

	public double DoubleItemPrices() {

		/*int sum = 0;
		for (Item i : items) {

			sum += sum + i.getPrice();
		}*/

		return productService.getTotalItemPrice() * 2;

	}

}
