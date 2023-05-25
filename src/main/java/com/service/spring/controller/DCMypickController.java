package com.service.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.AccountBook;
import com.service.spring.domain.DCMypick;
import com.service.spring.domain.DiscountCalendar;
import com.service.spring.model.AccountBookService;
import com.service.spring.model.DCMypickService;
import com.service.spring.model.DiscountCalendarService;

// 미완 화면없음
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/mypick")
public class DCMypickController {

	private final ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private DCMypickService dCMypickService;
	@Autowired
	private DiscountCalendarService discountCalendarService;
	@Autowired
	private AccountBookService accountBookService;

	@GetMapping("/isExist/{discountSeq}/{generalId}")
	public boolean isMypickExist(@PathVariable long discountSeq, @PathVariable String generalId) throws Exception {
		DCMypick mypick = new DCMypick();
		mypick.setDiscountSeq(discountSeq);
		mypick.setGeneralId(generalId);
		if (dCMypickService.isExist(mypick) == null)
			return false;
		else
			return true;
	}

	@GetMapping("/getReviews/{discountSeq}")
	public ResponseEntity<String> isMypickExist(@PathVariable long discountSeq) throws Exception {
		List<DCMypick> list = dCMypickService.getReviews(discountSeq);
		System.out.println(list);
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// 찜 추가
	@PutMapping("/like")
	public Map<String, String> addMyPick(@RequestBody DCMypick dCMypick) throws Exception {
		System.out.println(dCMypick);
		Map<String, String> map = new HashMap<String, String>();
		long discountSeq = dCMypick.getDiscountSeq();
		int insert = dCMypickService.insertDCMypick(dCMypick);
		long newLike = dCMypickService.getCountLike(discountSeq);
		DiscountCalendar dc = new DiscountCalendar();
		dc.setCalendarLike((int) newLike);
		dc.setDiscountSeq(discountSeq);
		System.out.println("찜~");
		discountCalendarService.updateCalendarLike(dc);
		map.put("result", "내 관심 정보에 등록되었습니다");
		map.put("newLike", newLike + "");
		return map;
	}

	// 찜 취소
	@PutMapping("/dislike")
	public Map<String, String> myPickCancel(@RequestBody DCMypick dCMypick) throws Exception {
		System.out.println(dCMypick);
		dCMypickService.deleteDCMypick(dCMypick);
		long newLike = dCMypickService.getCountLike(dCMypick.getDiscountSeq());
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "내 관심 정보에서 삭제되었습니다");
		map.put("newLike", newLike + "");
		return map;
	}

	// 리뷰작성, 사용으로 전환
	@PutMapping("/register")
	public String myPickUsed(@RequestBody DCMypick dCMypick) throws Exception {
		System.out.println("register==============");
		System.out.println(dCMypick);
		AccountBook accountBook = new AccountBook();
		accountBook.setDiscountSeq(dCMypick.getDiscountSeq());
		accountBook.setGeneralId(dCMypick.getGeneralId());
		try {
			long result = accountBookService.checkIsUsed(accountBook);
			if (result == dCMypick.getDiscountSeq()) {
				System.out.println(result);
				dCMypick.setMypickFlag(1);
				dCMypickService.updateUsedPick(dCMypick);
				return "리뷰가 등록되었습니다";
			}else
				return "사용한 정보만 리뷰를 등록할 수 있습니다.";

		} catch (Exception e) {
			return "사용한 정보만 리뷰를 등록할 수 있습니다.";
		}
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
