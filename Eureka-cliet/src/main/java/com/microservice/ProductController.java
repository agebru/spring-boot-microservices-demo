package com.microservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return ProductReposity.loadProducts();
	}
	
	
	@GetMapping("/products/{id}")
	public Product findOne(@PathVariable("id") int productId){
		return ProductReposity.findProduct(productId);
	}

}
