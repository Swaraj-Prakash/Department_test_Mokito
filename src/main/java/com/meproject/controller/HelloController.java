package com.meproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${welcome.message}")
	private String welcomMessage;
	
	@GetMapping("/")
	public String hello() {
		return welcomMessage ;
		//return "hello";
		
	}

}
