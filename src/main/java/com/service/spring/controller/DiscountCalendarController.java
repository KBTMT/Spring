package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.DiscountCalendar;
import com.service.spring.model.DiscountCalendarService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/discount-calendar")
public class DiscountCalendarController {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private DiscountCalendarService discountCalendarService;

	@GetMapping
	private ResponseEntity<String> getDiscountCalendar() throws Exception {
		List<DiscountCalendar> list = discountCalendarService.getDiscountCalendar();
		try {
			String jsonString = objectMapper.writeValueAsString(list);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/register")
    public String registerDiscountCalendar(@RequestBody DiscountCalendar discountCalendar) throws Exception {
		// 수정 필요
		discountCalendar.setUrl("www.test.com");
		System.out.println(discountCalendar);
		discountCalendarService.registerGeneralDiscountCalendar(discountCalendar);
		return "redirect:/discount-calendar";
    }
	
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

	@PostMapping("/update")
	public ModelAndView updateDiscountCalendar(@RequestBody DiscountCalendar discountCalendar) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/discount-calendar");
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
    public ModelAndView updateSpecificDiscountCalendar(@PathVariable Long discountSeq, @RequestBody DiscountCalendar discountCalendar) {
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

    @GetMapping("/delete/{discountSeq}")
    public ModelAndView deleteDiscountCalendar(@PathVariable Long discountSeq) {
        ModelAndView modelAndView = new ModelAndView("redirect:/discount-calendar");
        try {
            int result = discountCalendarService.deleteDiscountCalendar(discountSeq);
            if (result <= 0) {
                modelAndView.addObject("error", "Failed to delete discount calendar.");
            }
        } catch (Exception e) {
            modelAndView.addObject("error", "Failed to delete discount calendar.");
        }
        return modelAndView;
    }
}
