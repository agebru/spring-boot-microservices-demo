package com.microservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class HostsController {
	
	@Autowired
	private EurekaClient discoveryClient;
	@GetMapping("/instanceURL")
	public String serviceURL() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("eureka-client", false);
		System.out.println("Instance details: \nInstanceId:"+instance.getInstanceId()+"  AppName:"+instance.getAppName()+"  CountryId:"+instance.getCountryId()+"  HostName:"+instance.getHostName());;
		return instance.getHomePageUrl();
	}
	
	@GetMapping("/instances")
	public URI serviceUrl() {
	    List<ServiceInstance> list = discoveryClient.getInstancesById("eureka-client");
	    System.out.println("\n Number of Instances: "+list.size());
	    
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri();
	    }
	    return null;
	}

}
