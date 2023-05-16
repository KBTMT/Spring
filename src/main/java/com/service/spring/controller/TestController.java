package com.service.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.Board;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {

//test
	
//	@GetMapping("/api/hello")
//	public ResponseEntity<String> test() {
//		List<Board> list = new ArrayList();
//		Board b = new Board("userNickname", "titletest", "boardContent", "generalId");
//		System.out.println("Test=======");
//		try {
//			String jsonString = objectMapper.writeValueAsString(list);
//			return ResponseEntity.ok(jsonString);
//		} catch (JsonProcessingException e) {
//			System.out.println("error");
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
//	@GetMapping("/api/hello")
//	public Map<String, Object> getMyData() {
//	    Map<String, Object> result = new HashMap<>();
//	    result.put("name", "John");
//	    result.put("age", 30);
//	    return result;
//	}
//	@GetMapping("/api/hello")
//	public List<Map<String, Object>> getMyData() {
//	    List<Map<String, Object>> result = new ArrayList<>();
//
//	    Map<String, Object> data1 = new HashMap<>();
//	    data1.put("name", "John");
//	    data1.put("age", 30);
//	    result.add(data1);
//
//	    Map<String, Object> data2 = new HashMap<>();
//	    data2.put("name", "Jane");
//	    data2.put("age", 25);
//	    result.add(data2);
//
//	    return result;
//	}
	private final ObjectMapper objectMapper = new ObjectMapper();

//	@GetMapping("/api/hello")
//	public ResponseEntity<String> getMyData() {
//		List<Board> list = new ArrayList();
//		list.add( new Board("userNickname", "titletest", "boardContent", "generalId"));
//		list.add( new Board("userNickname2", "titletest2", "boardConten2t", "general2Id"));
//		try {
//			String jsonString = objectMapper.writeValueAsString(list);
//			return ResponseEntity.ok(jsonString);
//		} catch (JsonProcessingException e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}

}
