package com.service.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.AccountBook;
import com.service.spring.domain.DCMypick;
import com.service.spring.domain.DiscountCalendar;
import com.service.spring.domain.TmtUser;
import com.service.spring.model.AccountBookService;
import com.service.spring.model.DCMypickService;
import com.service.spring.model.DiscountCalendarService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin("*")
@RequestMapping("/account-book")
public class AccountBookController {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private DCMypickService dCMypickService;
	@Autowired
	private AccountBookService accountBookService;
	@Autowired
	private DiscountCalendarService discountCalendarService;

	@GetMapping
	public List<Map<String, Object>> getStat(@RequestParam("generalId") String generalId) throws Exception {
		List<Map<String, Object>> s = accountBookService.getStat(generalId);
		System.out.println(s);
		return s;
	}

	@GetMapping("/detail")
	public ResponseEntity<String> getAccountBook(@RequestParam("generalId") String generalId) throws Exception {
		List<AccountBook> accountBookList = accountBookService.getAccountBook(generalId);
		try {
			String jsonString = objectMapper.writeValueAsString(accountBookList);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/register")
	public String registerAccountBook(@RequestBody AccountBook accountBook, @RequestParam("generalId") String generalId)
			throws Exception {
		accountBook.setGeneralId(generalId);
		accountBookService.registerAccountBook(accountBook);
		return "redirect:/account-book/";
	}

	// 미완 화면 필요
	@PutMapping("/{accountBookSeq}/update")
	public ModelAndView updateAccountBook(@PathVariable long accountBookSeq, AccountBook accountBook,
			@RequestParam("generalId") String generalId) {
		// 수정 필요
		accountBook.setGeneralId(generalId);
		ModelAndView modelAndView = new ModelAndView("redirect:/account-book/" + accountBook.getGeneralId());
		try {
			accountBook.setAccountBookSeq(accountBookSeq);
			int result = accountBookService.updateAccountBook(accountBook);
			if (result <= 0) {
				modelAndView.addObject("error", "Failed to update account book.");
			}
		} catch (Exception e) {
			modelAndView.addObject("error", "Failed to update account book.");
		}
		return modelAndView;
	}

	// 미완 화면 필요
	@DeleteMapping("/{accountBookSeq}/delete")
	public String deleteAccountBook(@PathVariable long accountBookSeq, AccountBook accountBook) throws Exception {
		accountBookService.deleteAccountBook(accountBookSeq);
		return "redirect:/account-book/";
	}

	@GetMapping("/daily/{generalId}/{time}")
	public Map<String, Object> personalDailyAccountBook(@PathVariable String generalId, @PathVariable String time)
			throws Exception {
		AccountBook a = new AccountBook();
		a.setGeneralId(generalId);
		a.setTime(time);
		System.out.println("accountBook : " + a);

		List<AccountBook> accountBookList = accountBookService.personalDailyAccountBook(a);
		List<DiscountCalendar> discountCalendarList = discountCalendarService.getDiscountCalendarByDate(time);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accountBookList", accountBookList);
		map.put("discountCalendarList", discountCalendarList);
		return map;
	}

	@PutMapping("/daily/used/{accountBookSeq}")
	public String useDiscountInfo(@RequestBody DCMypick dCMypick, @PathVariable long accountBookSeq) throws Exception {
		System.out.println("useDiscountInfo===========");
		System.out.println(accountBookSeq);
		dCMypick.setMypickFlag(1);
		System.out.println(dCMypick);
		AccountBook ab = new AccountBook();
		ab.setAccountBookSeq(accountBookSeq);
		ab.setDiscountSeq(dCMypick.getDiscountSeq());
		try {
			int result = dCMypickService.usedPickInAccountBook(dCMypick);
			int result2 = accountBookService.registerDiscountCalendarInfo(ab);
			System.out.println(result2+"================");
			return "티끌이 등록되었습니다!";
		} catch (Exception e) {
			return "티끌이 등록에 실패하였습니다";
		}
	}
}