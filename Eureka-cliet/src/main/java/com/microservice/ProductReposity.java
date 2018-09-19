package com.microservice;

import java.util.ArrayList;
import java.util.List;

public class ProductReposity {
	private static List<Product> products=new ArrayList<Product>();
	
	static {
		Product p1=new Product(1001,"Computer",1500.0);
		Product p2=new Product(1005,"Book",300.0);
		Product p3=new Product(1020,"Cereal",800.0);
		Product p4=new Product(1030,"Dressing",250.0);
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
	}

	
	public static List<Product> loadProducts(){
		return products;
	}
	
	
	public static Product findProduct(int productId){
		return products.stream().filter(prodct->prodct.getProductId()==productId).findFirst().get();
	}
}
