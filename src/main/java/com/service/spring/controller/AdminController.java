package com.service.spring.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.Reported;
import com.service.spring.model.BCommentService;
import com.service.spring.model.BoardService;
import com.service.spring.model.DiscountCalendarService;
import com.service.spring.model.ReportedService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

	private final ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private ReportedService reportedService;
	@Autowired
	private DiscountCalendarService discountCalendarService;
	@Autowired
	private BCommentService bCommentService;
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/register")
	public ModelAndView registerReported(@ModelAttribute Reported reported) {
		try {
			reportedService.registerReported(reported);
			return new ModelAndView("redirect:/reported");
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

//	@PutMapping("/{reportedSeq}/update")
//	public ModelAndView updateReported(@PathVariable Long reportedSeq, @ModelAttribute Reported reported) {
//		try {
//			reported.setReportedSeq(reportedSeq);
//			reportedService.updateReported(reported);
//			return new ModelAndView("redirect:/reported");
//		} catch (Exception e) {
//			return new ModelAndView("error");
//		}
//	}

	@GetMapping("/reported")
	public ResponseEntity<String> getReported() throws Exception {
		List<Reported> reportedList = reportedService.getReported();
		try {
			String jsonString = objectMapper.writeValueAsString(reportedList);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/reported/detail/{reportedSeq}/{status}/{reportedFlag}")
	public ResponseEntity<String> getReportedDetail(@PathVariable String reportedSeq, @PathVariable String status, @PathVariable String reportedFlag) throws Exception {
		System.out.println("============");
		System.out.println("reportedSeq  :"+reportedSeq);
		System.out.println("status : "+status);
		System.out.println("reportedFlag : "+reportedFlag);
//		Reported reported = reportedService.getReportDetail(reported);
//		try {
//			String jsonString = objectMapper.writeValueAsString(reported);
//			return ResponseEntity.ok(jsonString);
//		} catch (JsonProcessingException e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
		return null;
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