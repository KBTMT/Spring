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
@RequestMapping
public class AccountController {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private AccountService accountService;

	@GetMapping("/account/get")
	public void auth(@RequestParam String code, @RequestParam String scope, @RequestParam String state,
			HttpServletResponse response) throws Exception {
		System.out.println("code : " + code);
		String redirectUrl = "https://testapi.openbanking.or.kr/oauth/2.0/token?code=" + code
				+ "&client_id=27cbcd6b-8cdc-4499-a076-d058c4132ce7&client_secret=2605f0c1-83ad-4aab-9b97-8ee38ca727b4&redirect_uri=http://localhost:8899/account/get/token&grant_type=authorization_code";
		response.sendRedirect(redirectUrl);
	}

	@PostMapping("/account/get/token")
	public String getToken(@RequestBody Map<String, Object> requestData) throws Exception {
		System.out.println("getToken");
		System.out.println(requestData);
		return "123";
	}

	@PostMapping("/register")
	public String registerAccount(@RequestBody Map<String, Object> requestData) throws Exception {
//		accountService.insertAccount(requestData);
//		return "answer";

		return "123";
	}

	@GetMapping("/get")
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
	public ResponseEntity<String> getAccount(@RequestBody String accountNumber) throws Exception {
		List<AccountTransaction> list = accountService.getAccountTransaction(accountNumber);
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/delete")
	public String deleteAccount(@RequestBody String accountNumber) throws Exception {
		try {
			accountService.deleteAccount(accountNumber);
			return "삭제 성공";
		} catch (Exception e) {
			return "삭제 실패";
		}
	}

}
