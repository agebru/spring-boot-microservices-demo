package com.microservice;

import java.util.List;

import org.apache.commons.math.stat.descriptive.summary.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;



@RestController
public class ConsumerProductController {

    @Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from ==> "+ eurekaClient.getNextServerFromEureka("consumer-service", false) +" running at port: " + env.getProperty("local.server.port");
}

	@SuppressWarnings("unchecked")
	@GetMapping("/all")
	public List<Product> getProducts() {  
		List<?> products = restTemplate.getForObject("http://eureka-client/products/", List.class);
		System.out.println("==== getting all the records from the Eureka-Client appliction   =====");

		return (List<Product>)products;

	}

	@GetMapping("all/{id}")
	public Product findproduct(@PathVariable("id")int id) {
		

		Product product=restTemplate.getForObject("http://eureka-client/products/{id}", Product.class,id);
		
		return product;
	}

}
