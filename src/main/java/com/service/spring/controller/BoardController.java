package com.service.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.service.spring.domain.BComment;
import com.service.spring.domain.Board;
import com.service.spring.domain.Reported;
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
		System.out.println(board);
		board.setGeneralId(board.getGeneralId());
		board.setUserNickname(board.getUserNickname());
		System.out.println(board);
		
		if (board.getGeneralId() == null) {
	        // generalId 필드가 NULL인 경우 예외 처리
	        throw new IllegalArgumentException("generalId가 필요합니다.");
	    }
		
		boardService.insertBoard(board);
		return "redirect:/board";
	}

	// 수정 필요 
	@PutMapping("/update")
	public ModelAndView updateBoard(@PathVariable Long boardSeq, @ModelAttribute Board board) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		board.setBoardSeq(boardSeq);
		boardService.updateBoard(board);
		modelAndView.setViewName("redirect:/board" + boardSeq);
		return modelAndView;
	}
	// 수정 필요 
	@DeleteMapping("/{boardSeq}/delete")
	public ModelAndView deletedBoard(@PathVariable Long boardSeq) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		boardService.deleteBoard(boardSeq);
		modelAndView.setViewName("redirect:/board");
		return modelAndView;
	}

	// 수정 필요
	@GetMapping("/detail/{boardSeq}")
	public Map<String, Object> showBoardDetail(@PathVariable Long boardSeq) throws Exception {
		Board board = boardService.getBoard(boardSeq);
		List<BComment> bCommentList = bCommentService.getBComment(boardSeq);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		map.put("comment",bCommentList);
		return map;
	}

	@PostMapping("/{boardSeq}/{bCommentSeq}")
	public ModelAndView registerBComment(@PathVariable Long boardSeq, BComment bComment) throws Exception {
		bComment.setBoardSeq(boardSeq);
		bCommentService.insertBComment(bComment);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}

	@PutMapping("/{boardSeq}/{bCommentSeq}/update")
	public ModelAndView updateBComment(@PathVariable Long boardSeq, @PathVariable Long bCommentSeq, BComment bComment)
			throws Exception {
		bCommentService.updateBComment(bComment);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}

	@PutMapping("/{boardSeq}/{bCommentSeq}/delete")
	public ModelAndView deletedBComment(@PathVariable Long boardSeq, @PathVariable Long commentSeq, BComment bComment)
			throws Exception {
		bCommentService.deleteBComment(commentSeq);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}
	
	@PostMapping("/{boardSeq}/report")
	public ModelAndView reportBoard(@PathVariable Long boardSeq, @RequestBody Board board) throws Exception {
		Reported reported   = new Reported(boardSeq, 0, 1);
	    // 필요한 필드 값들을 reported 객체에 설정
	    reportedService.registerReported(reported);
	    
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("redirect:/board");
	    return modelAndView;
	}
	
	@PostMapping("/{bCommentSeq}/report")
	public ModelAndView reportBoardComment(@PathVariable Long bCommentSeq) throws Exception {
		Reported reported   = new Reported(bCommentSeq, 0, 2);
	    // 필요한 필드 값들을 reported 객체에 설정
	    reportedService.registerReported(reported);
	    
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("redirect:/board");
	    return modelAndView;
	}
	
	
	@PostMapping("/{boardSeq}/like")
    public ModelAndView increaseLikes(@PathVariable Long boardSeq) throws Exception {
        Board board = boardService.getBoard(boardSeq);
        if (board != null) {
            int likes = board.getBoardLike();
            board.setBoardLike(likes + 1);
            boardService.updateBoard(board);
        }
        return new ModelAndView("redirect:/board");
    }
}