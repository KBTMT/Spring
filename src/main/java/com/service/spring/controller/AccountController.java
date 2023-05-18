package com.service.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.BComment;
import com.service.spring.domain.Board;
import com.service.spring.model.BCommentService;
import com.service.spring.model.BoardService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
public class AccountController {
	private final ObjectMapper objectMapper = new ObjectMapper();


	@GetMapping("/get/{code}/{scope}/{state}")
	public void getToekn(@PathVariable("code") String code, @PathVariable("scope") String scope, @PathVariable("state") String stat) throws Exception {
		System.out.println(code);
		System.out.println(scope);
		System.out.println(stat);
	}
}
