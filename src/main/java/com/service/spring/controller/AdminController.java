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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// 승인 안된것 부터 정렬 필요
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

	@GetMapping("/reported/detail/{targetSeq}/{status}/{reportedFlag}")
	public ResponseEntity<String> getReportedDetail(@PathVariable long targetSeq, @PathVariable int status,
			@PathVariable int reportedFlag) throws Exception {
		if (reportedFlag == 0) { // 할인 달력
			return ResponseEntity.ok(objectMapper.writeValueAsString(discountCalendarService.getDiscountCalendarbySeq(targetSeq)));
		} else if (reportedFlag == 1) { // 게시판 글
			return ResponseEntity.ok(objectMapper.writeValueAsString(boardService.getBoard(targetSeq)));
		} else if (reportedFlag == 2) { // 댓글
			return ResponseEntity.ok(objectMapper.writeValueAsString(bCommentService.getBCommentbySeq(targetSeq)));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping("reported/detail/delete")
	public void deleteReported(@RequestBody Reported reported) throws Exception {
		System.out.println(reported);
		if (reported.getReportedFlag() == 0) { // 할인 달력
			discountCalendarService.deleteDiscountCalendar(reported.getTargetSeq());
			reportedService.deleteReported(reported);
		} else if (reported.getReportedFlag() == 1) { // 게시판 글
			boardService.deleteBoard(reported.getTargetSeq());
			reportedService.deleteReported(reported);
		} else if (reported.getReportedFlag() == 2) { // 댓글
			bCommentService.deleteBComment(reported.getTargetSeq());
			reportedService.deleteReported(reported);
		}
	}
	@PutMapping("reported/detail/approve")
	public void approvedReported(@RequestBody Reported reported) throws Exception {
		System.out.println(reported);
		reportedService.updateReported(new Reported(reported.getTargetSeq(), 1 ,reported.getReportedFlag()));
	}
}