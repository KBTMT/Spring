package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/register")
	public String registerAccount(@RequestBody Account account) throws Exception {
		accountService.insertAccount(account);
		return "answer";
	}
	@GetMapping("/get/account")
	public  ResponseEntity<String> getAccount() throws Exception{
		// 세션 처리
		String generalId = "testId";
		List<Account> list = accountService.getAccount(generalId);
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/get/transaction")
	public  ResponseEntity<String> getAccount(@RequestBody String accountNumber) throws Exception{
		List<AccountTransaction> list = accountService.getAccountTransaction(accountNumber);
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/delete")
	public String deleteAccount(@RequestBody String accountNumber) throws Exception{
		try {
			accountService.deleteAccount(accountNumber);
			return "삭제 성공";
		} catch (Exception e) {
			return "삭제 실패";
		}
	}

}
