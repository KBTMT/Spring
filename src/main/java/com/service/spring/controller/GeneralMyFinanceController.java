package com.service.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

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
import com.service.spring.model.AnalysisDAO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/generalmypage/generalMyFinance")
public class GeneralMyFinanceController {

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private AnalysisDAO analysisDAO;  
	@GetMapping
	public Map<String,List<Map<String, Object>>> getData() throws Exception {
		System.out.println("=============");
		String month = "4";
		Map<String,List<Map<String, Object>>> map = new HashMap<String, List<Map<String,Object>>>();
		map.put("getAnalysisByCat", analysisDAO.getAnalysisByCat(month));
		map.put("getMaxCat", analysisDAO.getMaxCat(month));
		map.put("getAnalysisByHour", analysisDAO.getAnalysisByHour(month));
		map.put("sumConsumption", analysisDAO.sumConsumption(month));
		map.put("sumIncome", analysisDAO.sumIncome(month));
		List<Map<String,Object>> target = new ArrayList<Map<String,Object>>();
		// 세션에서 가져오기 (목표금액)
		Map<String, Object> tt = new HashMap<String, Object>();
		tt.put("target",1500000);
		map.put("targetSaving",new ArrayList<>(Arrays.asList(tt)));
	
		return map;
	}

}
