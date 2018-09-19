package com.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class DiscoverOtherClientsController {
	
	@Autowired
	private EurekaClient discoveryClient;
	
	@Autowired
	private Environment environment;
	
	
	@GetMapping("/instanceURL")
	public String serviceURL() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("consumer-service", false);
		System.out.println("Instance details: \nInstanceId:"+instance.getInstanceId()+"  AppName:"+instance.getAppName()+"  CountryId:"+instance.getCountryId()+"  HostName:"+instance.getHostName());;
		return instance.getHomePageUrl();
	}
	
	@GetMapping("/instance")
	public String getInstance() {
		return "Hello from Eureka-client mic running at port: " + environment.getProperty("local.server.port");
	}
	
	@GetMapping("/")
	public String home() {
		return "Hello from ==> "+ discoveryClient.getNextServerFromEureka("eureka-client", false) +" running at port: " + environment.getProperty("local.server.port");
	}

}
