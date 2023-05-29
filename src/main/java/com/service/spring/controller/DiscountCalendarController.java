package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.BComment;
import com.service.spring.domain.Board;
import com.service.spring.domain.DiscountCalendar;
import com.service.spring.domain.Reported;
import com.service.spring.model.AccountBookService;
import com.service.spring.model.DCMypickService;
import com.service.spring.model.DiscountCalendarService;
import com.service.spring.model.ReportedService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin("*")
@RequestMapping("/discount-calendar")
public class DiscountCalendarController {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private DiscountCalendarService discountCalendarService;
	@Autowired
	private AccountBookService accountBookService;

	@GetMapping
	private ResponseEntity<String> getDiscountCalendar() throws Exception {
		List<DiscountCalendar> list = discountCalendarService.getDiscountCalendar();
		System.out.println(list);
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/myTickle/{generalId}")
	private long getMyTickle(@PathVariable String generalId) throws Exception{
		System.out.println(generalId);
		long result = accountBookService.getMyTickle(generalId);
		System.out.println(result+"개 티끌 사용함");
		return result;
	}
	
	@PostMapping("/register")
	public String registerDiscountCalendar(@RequestBody DiscountCalendar discountCalendar) throws Exception {
		System.out.println(discountCalendar);
		discountCalendarService.registerGeneralDiscountCalendar(discountCalendar);
		return "redirect:/discount-calendar";
	}

	// 미완 비즈니스 어떻
	@PostMapping("/business")
	public ModelAndView registerBusinessDiscountCalendar(@RequestBody DiscountCalendar discountCalendar) {
		ModelAndView modelAndView = new ModelAndView("redirect:/discount-calendar");
		try {
			int result = discountCalendarService.registerBusinessDiscountCalendar(discountCalendar);
			if (result <= 0) {
				modelAndView.addObject("error", "Failed to register business discount calendar.");
			}
		} catch (Exception e) {
			modelAndView.addObject("error", "Failed to register business discount calendar.");
		}
		return modelAndView;
	}

	@PutMapping("/update")
	public String updateDiscountCalendar(@RequestBody DiscountCalendar discountCalendar) throws Exception {
		discountCalendarService.updateDiscountCalender(discountCalendar);
		return "redirect:/discount-calendar";
	}

	@PostMapping("/update2")
	ModelAndView updateBusinessDiscountCalendar(DiscountCalendar discountCalendar) {
		ModelAndView modelAndView = new ModelAndView("redirect:/discount-calendar");
		try {
			int result = discountCalendarService.updateBusinessDiscountCalendar(discountCalendar);
			if (result <= 0) {
				modelAndView.addObject("error", "Failed to update business discount calendar.");
			}
		} catch (Exception e) {
			modelAndView.addObject("error", "Failed to update business discount calendar.");
		}
		return modelAndView;
	}

	@PostMapping("/update/{discountSeq}")
	public ModelAndView updateSpecificDiscountCalendar(@PathVariable Long discountSeq,
			@RequestBody DiscountCalendar discountCalendar) {
		ModelAndView modelAndView = new ModelAndView("redirect:/discount-calendar");
		discountCalendar.setDiscountSeq(discountSeq);
		try {
			int result = discountCalendarService.updateDiscountCalender(discountCalendar);
			if (result <= 0) {
				modelAndView.addObject("error", "Failed to update discount calendar.");
			}
		} catch (Exception e) {
			modelAndView.addObject("error", "Failed to update discount calendar.");
		}
		return modelAndView;
	}

	@DeleteMapping("/delete/{discountSeq}")
	public String deleteDiscountCalendar(@PathVariable Long discountSeq) {
		try {
			int result = discountCalendarService.deleteDiscountCalendar(discountSeq);
			if (result <= 0) {
				return "redirect:/discount-calendar?error=Failed to delete discount calendar.";
			}
		} catch (Exception e) {
			return "redirect:/discount-calendar?error=Failed to delete discount calendar.";
		}
		return "redirect:/discount-calendar";
	}



	@PostMapping("/{discountSeq}/like")
	public ModelAndView increaseLikes(@PathVariable Long discountSeq) throws Exception {
		DiscountCalendar discountCalendar = discountCalendarService.getDiscountCalendarbySeq(discountSeq);
		if (discountCalendar != null) {
			int likes = discountCalendar.getCalendarLike();
			discountCalendar.setCalendarLike(likes + 1);
			discountCalendarService.updateDiscountCalender(discountCalendar);
		}
		return new ModelAndView("redirect:/discount-calendar");
	}
}
