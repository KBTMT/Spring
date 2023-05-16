package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.DiscountCalendar;
import com.service.spring.model.DiscountCalendarService;

@Controller
@RequestMapping("/discount-calendar")
public class DiscountCalendarController {

	@Autowired
	private DiscountCalendarService discountCalendarService;

	@GetMapping
	private ModelAndView getDiscountCalendar() throws Exception {
		List<DiscountCalendar> list = discountCalendarService.getDiscountCalendar();
		return new ModelAndView("discountCalendars", "list", list);
	}
	
	@PostMapping("/general")
    public ModelAndView registerGeneralDiscountCalendar(@ModelAttribute DiscountCalendar discountCalendar) {
        ModelAndView modelAndView = new ModelAndView("redirect:/discount-calendar");
        try {
            int result = discountCalendarService.registerGeneralDiscountCalendar(discountCalendar);
            if (result <= 0) {
                modelAndView.addObject("error", "Failed to register general discount calendar.");
            }
        } catch (Exception e) {
            modelAndView.addObject("error", "Failed to register general discount calendar.");
        }
        return modelAndView;
    }
	
	@PostMapping("/business")
    public ModelAndView registerBusinessDiscountCalendar(@ModelAttribute DiscountCalendar discountCalendar) {
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
	public ModelAndView updateDiscountCalendar(@ModelAttribute DiscountCalendar discountCalendar) {
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

	@PostMapping("/update")
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
    public ModelAndView updateSpecificDiscountCalendar(@PathVariable Long discountSeq, @ModelAttribute DiscountCalendar discountCalendar) {
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
