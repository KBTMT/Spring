package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.Board;
import com.service.spring.model.BoardService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/myactivity")
public class MyActivityController {
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/myboard")
	public ResponseEntity<String> showMyBoard(@RequestParam String generalId) throws Exception{
		List<Board> boardList = boardService.getBoard(generalId);
		try {
			String jsonString = objectMapper.writeValueAsString(boardList);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
