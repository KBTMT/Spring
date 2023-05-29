package com.service.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.Account;
import com.service.spring.domain.AccountTransaction;
import com.service.spring.model.AccountService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
public class AccountController {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private AccountService accountService;

	@GetMapping("/{generalId}/isExist")
	public boolean isExist(@PathVariable String generalId) throws Exception {
		List<Account> list = accountService.getAccount(generalId);
		if (list.size() > 0)
			return true;
		else
			return false;
	}
	
	@PostMapping("/account/get/token")
	public void getToken(@RequestBody Map<String, Object> requestData) throws Exception {
		System.out.println("getToken");
		System.out.println(requestData);
	}
	
	@PostMapping("/register")
	public String registerAccount(@RequestBody Map<String, String> requestBody) throws Exception {
		System.out.println("=================");
		System.out.println(requestBody.get("generalId"));
		Account account = new Account(requestBody.get("generalId"), "국민은행", requestBody.get("code"), "1234", requestBody.get("generalId"));
		accountService.insertAccount(account);
		return "계좌가 등록되었습니다";
	}



}
