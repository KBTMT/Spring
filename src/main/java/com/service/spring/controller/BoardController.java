package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.BComment;
import com.service.spring.domain.Board;
import com.service.spring.model.BCommentService;
import com.service.spring.model.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private BCommentService bCommentService;

	@GetMapping()
	public ModelAndView showAllBoard() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<Board> boardList = boardService.getBoard();
		modelAndView.addObject("boardList", boardList);
		modelAndView.setViewName("boardList");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView registerBoard(@ModelAttribute Board board) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		boardService.insertBoard(board);
		modelAndView.setViewName("redirect:/board");
		return modelAndView;
	}

	@PutMapping("/{boardSeq}")
	public ModelAndView updateBoard(@PathVariable Long boardSeq, @ModelAttribute Board board) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		board.setBoardSeq(boardSeq);
		boardService.updateBoard(board);
		modelAndView.setViewName("redirect:/board" + boardSeq);
		return modelAndView;
	}

	@DeleteMapping("/{boardSeq}")
	public ModelAndView deletedBoard(@PathVariable Long boardSeq) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		boardService.deleteBoard(boardSeq);
		modelAndView.setViewName("redirect:/board");
		return modelAndView;
	}

	@GetMapping("/{boardSeq}")
	public ModelAndView showBoardDetail(@PathVariable Long boardSeq) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Board board = boardService.getBoard(boardSeq);
		List<BComment> bCommentList = bCommentService.getBComment(boardSeq);
		modelAndView.addObject("board", board);
		modelAndView.addObject("bCommentList", bCommentList);
		modelAndView.setViewName("boardDetail");
		return modelAndView;
	}

	@PostMapping("/{boardSeq}")
	public ModelAndView registerBComment(@PathVariable Long boardSeq, BComment bComment) throws Exception {
		bComment.setBoardSeq(boardSeq);
		bCommentService.insertBComment(bComment);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}

	@PutMapping("/{boardSeq}/{commentSeq}")
	public ModelAndView updateBComment(@PathVariable Long boardSeq, @PathVariable Long commentSeq, BComment bComment)
			throws Exception {
		bCommentService.updateBComment(bComment);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}

	@PutMapping("/{boardSeq}/{commentSeq}")
	public ModelAndView deletedBComment(@PathVariable Long boardSeq, @PathVariable Long commentSeq, BComment bComment)
			throws Exception {
		bCommentService.deleteBComment(commentSeq);
		ModelAndView mav = new ModelAndView("redirect:/board/" + boardSeq);
		return mav;
	}
}
