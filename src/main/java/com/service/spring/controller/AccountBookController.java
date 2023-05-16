package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.AccountBook;
import com.service.spring.model.AccountBookDAO;

@Controller
@RequestMapping("/account-book")
public class AccountBookController {
	private final AccountBookDAO accountBookDAO;

    @Autowired
    public AccountBookController(AccountBookDAO accountBookDAO) {
        this.accountBookDAO = accountBookDAO;
    }

    @GetMapping("/{generalId}")
    public ModelAndView getAccountBook(@PathVariable String generalId) {
        ModelAndView modelAndView = new ModelAndView("accountBook");
        try {
            List<AccountBook> accountBookList = accountBookDAO.getAccountBook(generalId);
            modelAndView.addObject("accountBookList", accountBookList);
        } catch (Exception e) {
            modelAndView.addObject("error", "Failed to retrieve account book.");
        }
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerAccountBook(AccountBook accountBook) {
        ModelAndView modelAndView = new ModelAndView("redirect:/account-book/" + accountBook.getGeneralId());
        try {
            int result = accountBookDAO.registerAccountBook(accountBook);
            if (result <= 0) {
                modelAndView.addObject("error", "Failed to register account book.");
            }
        } catch (Exception e) {
            modelAndView.addObject("error", "Failed to register account book.");
        }
        return modelAndView;
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
    public ModelAndView deleteAccountBook(@PathVariable long accountBookSeq, AccountBook accountBook) {
        ModelAndView modelAndView = new ModelAndView("redirect:/account-book/" + accountBook.getGeneralId());
        try {
            int result = accountBookDAO.deleteAccountBook(accountBookSeq);
            if (result <= 0) {
                modelAndView.addObject("error", "Failed to delete account book.");
            }
        } catch (Exception e) {
            modelAndView.addObject("error", "Failed to delete account book.");
        }
        return modelAndView;
    }

    @GetMapping("/daily/{time}")
    public ModelAndView dailyAccountBook(@PathVariable String time) {
        ModelAndView modelAndView = new ModelAndView("dailyAccountBook");
        try {
            List<AccountBook> accountBookList = accountBookDAO.dailyAccountBook(time);
            modelAndView.addObject("accountBookList", accountBookList);
        } catch (Exception e) {
        modelAndView.addObject("error", "Failed to retrieve daily account book.");
        }
        return modelAndView;
    }
}