package com.eureka.hello.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController 
{
   private final Logger logger = Logger.getLogger(getClass());
   
   @Autowired
   private DiscoveryClient client;
   
   @RequestMapping(value="/hello",method=RequestMethod.GET)
   public String index(){
	   ServiceInstance instance = client.getLocalServiceInstance();
	   logger.info("hello world"+":"+instance.getServiceId());
	   return "Hello World!";
   }
}
