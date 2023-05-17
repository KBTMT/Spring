package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Reported;
import com.service.spring.model.ReportedService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/reported")
public class ReportedController {

	@Autowired
	private ReportedService reportedService;

	@PostMapping("/register")
	public ModelAndView registerReported(@ModelAttribute Reported reported) {
	    try {
	        reportedService.registerReported(reported);
	        return new ModelAndView("redirect:/reported");
	    } catch (Exception e) {
	        return new ModelAndView("error");
	    }
	}

	@PutMapping("/{reportedSeq}/update")
	public ModelAndView updateReported(@PathVariable Long reportedSeq, @ModelAttribute Reported reported) {
	    try {
	        reported.setReportedSeq(reportedSeq);
	        reportedService.updateReported(reported);
	        return new ModelAndView("redirect:/reported");
	    } catch (Exception e) {
	        return new ModelAndView("error");
	    }
	}

	@GetMapping
	public ModelAndView getReported() {
	    try {
	        List<Reported> reportedList = reportedService.getReported();
	        ModelAndView modelAndView = new ModelAndView("reported");
	        modelAndView.addObject("reportedList", reportedList);
	        return modelAndView;
	    } catch (Exception e) {
	        return new ModelAndView("error");
	    }
	}

	@DeleteMapping("/{reportedSeq}/delete")
	public ModelAndView deleteReported(@PathVariable Long reportedSeq, @ModelAttribute Reported reported) {
	    try {
	        reported.setReportedSeq(reportedSeq);
	        int result = reportedService.deleteReported(reported);
	        if (result == 1) {
	            return new ModelAndView("redirect:/reported");
	        } else {
	            return new ModelAndView("error");
	        }
	    } catch (Exception e) {
	        return new ModelAndView("error");
	    }
	}
}