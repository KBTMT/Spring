package com.service.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.AccountBook;
import com.service.spring.model.AccountBookDAO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account-book")
public class AccountBookController {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private final AccountBookDAO accountBookDAO;

    @Autowired
    public AccountBookController(AccountBookDAO accountBookDAO) {
        this.accountBookDAO = accountBookDAO;
    }

    @GetMapping()
    public List<Map<String, Object>> getStat() throws Exception {
    	List<Map<String, Object>> s =  accountBookDAO.getStat("generalId1");
    	System.out.println(s);
    	return s;
    }
    @GetMapping("/detail")
    public ResponseEntity<String> getAccountBook() throws Exception {
    	//세션에서 가져오는 걸로 변경할 것
    	List<AccountBook> accountBookList = accountBookDAO.getAccountBook("generalId1");
        try {
        	String jsonString = objectMapper.writeValueAsString(accountBookList);
			return ResponseEntity.ok(jsonString);
        } catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }

    @PostMapping("/register")
    public String registerAccountBook(@RequestBody AccountBook accountBook) throws Exception {
    	accountBookDAO.registerAccountBook(accountBook);
        return "redirect:/account-book/";
    }

    @PostMapping("/{accountBookSeq}/update")
    public ModelAndView updateAccountBook(@PathVariable long accountBookSeq, AccountBook accountBook) {
        ModelAndView modelAndView = new ModelAndView("redirect:/account-book/" + accountBook.getGeneralId());
        try {
            accountBook.setAccountBookSeq(accountBookSeq);
            int result = accountBookDAO.updateAccountBook(accountBook);
            if (result <= 0) {
                modelAndView.addObject("error", "Failed to update account book.");
            }
        } catch (Exception e) {
            modelAndView.addObject("error", "Failed to update account book.");
        }
        return modelAndView;
    }

    @PostMapping("/{accountBookSeq}/delete")
    public String deleteAccountBook(@PathVariable long accountBookSeq, AccountBook accountBook) throws Exception {
        accountBookDAO.deleteAccountBook(accountBookSeq);
        return "redirect:/account-book/";
    }

    @GetMapping("/daily/{time}")
    public ResponseEntity<String> dailyAccountBook(@PathVariable String time) throws Exception {
        List<AccountBook> accountBookList = accountBookDAO.dailyAccountBook(time);
        try {
			String jsonString = objectMapper.writeValueAsString(accountBookList);
			return ResponseEntity.ok(jsonString);
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
}