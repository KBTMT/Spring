package com.service.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.service.spring.domain.DCMypick;
import com.service.spring.domain.DiscountCalendar;
import com.service.spring.model.BoardService;
import com.service.spring.model.DCMypickService;
import com.service.spring.model.DiscountCalendarService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/myactivity")
public class MyActivityController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private DCMypickService dCMypickService;
	@Autowired
	private DiscountCalendarService discountCalendarService;

	@GetMapping
	public Map<String, Object> showMyActivity(@RequestParam String generalId) throws Exception {
		System.out.println(generalId);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Board> boardList = boardService.getBoard(generalId);
		List<DCMypick> mypickList = dCMypickService.getDCMypick(generalId);
		List<DiscountCalendar> calendarList = new ArrayList<DiscountCalendar>();
		for(DCMypick pick : mypickList) {
			try {
				calendarList.add(discountCalendarService.getDiscountCalendarbySeq(pick.getDiscountSeq()));
			}catch (Exception e) {
				System.out.println("해당 calendar 존재하지 않음");
			}
		}
		map.put("board", boardList);
		map.put("mypick", calendarList);
		return map;
	}

}
