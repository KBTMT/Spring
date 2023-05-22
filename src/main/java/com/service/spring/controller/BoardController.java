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
import com.service.spring.model.ReportedService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/board")
public class BoardController {
	private final ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReportedService reportedService;

	@Autowired
	private BCommentService bCommentService;

	@GetMapping
	public ResponseEntity<String> showAllBoard() throws Exception {
		List<Board> boardList = boardService.getBoard(); 
		try {
			String jsonString = objectMapper.writeValueAsString(boardList);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/register")
	public String registerBoard(@RequestBody Board board) throws Exception {
		// 수정할 것 -> 세션에서 user generalId, userNickname
		board.setGeneralId("generalId Test");
		board.setUserNickname("test3");
		
		System.out.println(board);
		boardService.insertBoard(board);
		return "redirect:/board";
	}

	@PutMapping("/update")
	public ModelAndView updateBoard(@PathVariable Long boardSeq, @ModelAttribute Board board) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		board.setBoardSeq(boardSeq);
		boardService.updateBoard(board);
		modelAndView.setViewName("redirect:/board" + boardSeq);
		return modelAndView;
	}

	@DeleteMapping("/{boardSeq}/delete")
	public ModelAndView deletedBoard(@PathVariable Long boardSeq) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		boardService.deleteBoard(boardSeq);
		modelAndView.setViewName("redirect:/board");
		return modelAndView;
	}

	// 수정 필요
	@GetMapping("/detail/{boardSeq}")
	public ResponseEntity<String> showBoardDetail(@PathVariable Long boardSeq) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Board board = boardService.getBoard(boardSeq);
		List<BComment> bCommentList = bCommentService.getBComment(boardSeq);
		try {
        	String jsonString = objectMapper.writeValueAsString(bCommentList);
			return ResponseEntity.ok(jsonString);
        } catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/{boardSeq}/{bCommentSeq}")
	public ModelAndView registerBComment(@PathVariable Long boardSeq, BComment bComment) throws Exception {
		bComment.setBoardSeq(boardSeq);
		bCommentService.insertBComment(bComment);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}

	@PutMapping("/{boardSeq}/{commentSeq}/update")
	public ModelAndView updateBComment(@PathVariable Long boardSeq, @PathVariable Long commentSeq, BComment bComment)
			throws Exception {
		bCommentService.updateBComment(bComment);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}

	@PutMapping("/{boardSeq}/{commentSeq}/delete")
	public ModelAndView deletedBComment(@PathVariable Long boardSeq, @PathVariable Long commentSeq, BComment bComment)
			throws Exception {
		bCommentService.deleteBComment(commentSeq);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}
}
