package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping()
	public String login(String type, String userId, String password) {
		
		return "";
	}
}
