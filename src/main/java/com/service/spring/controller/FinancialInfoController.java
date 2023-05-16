package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.Board;
import com.service.spring.domain.FinancialInfo;
import com.service.spring.model.FinancialInfoDAO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/finance")
public class FinancialInfoController {
	private final ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private FinancialInfoDAO financialInfoDAO;

	@GetMapping
	public ResponseEntity<String> showAllBoard() throws Exception {
		//날짜 변환 수정 필요
		List<FinancialInfo> list = financialInfoDAO.getFinancialInfo("date");
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
