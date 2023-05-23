package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.Board;
import com.service.spring.domain.DCMypick;
import com.service.spring.model.DCMypickService;
// 미완 화면없음
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/mypick")
public class DCMypickController {

	private final ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private DCMypickService dCMypickService;
	
	// 찜 추가
	@PostMapping("/add")
	public String addMyPick(@RequestBody DCMypick dCMypick, @RequestParam("generalId") String generalId) throws Exception {
		dCMypick.setGeneralId(generalId);
		dCMypickService.insertDCMypick(dCMypick);
		return "redirect:/";
	}
	
	// 리뷰작성, 사용으로 전환
	@PutMapping("/used")
	public String myPickUsed(@RequestBody DCMypick dCMypick, @RequestParam("generalId") String generalId) throws Exception {
		dCMypick.setGeneralId(generalId);
		if (dCMypick.getMypickFlag() == 1) {
            int score = dCMypick.getScore();
            String review = dCMypick.getReview();
		}
		dCMypickService.updateUsedPick(dCMypick);
		return "redirect:/";
	}
	
	// 찜 취소
	@DeleteMapping("/delete")
	public String myPickCancel(@RequestBody DCMypick dCMypick, @RequestParam("generalId") String generalId) throws Exception {
		dCMypick.setGeneralId(generalId);
		dCMypickService.deleteDCMypick(dCMypick);
		return "redirect:/";
	}
	
	// 내가 찜한 정보
	@GetMapping("/get")
	public ResponseEntity<String> showMyPick(@RequestParam("generalId") String generalId) throws Exception {
		List<DCMypick> list = dCMypickService.getDCMypick(generalId);
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	// 사용한 정보
	@GetMapping("/get/used")
	public ResponseEntity<String> showUsed(@RequestParam String generalId) throws Exception {
		List<DCMypick> list = dCMypickService.getDCMypickUsed(generalId);
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
