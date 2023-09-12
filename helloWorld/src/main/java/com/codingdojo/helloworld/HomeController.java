package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "Hello World";			
	}
}
