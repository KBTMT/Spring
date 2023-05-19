package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Account;
import com.service.spring.domain.AccountTransaction;
import com.service.spring.model.AccountDAO;
import com.service.spring.model.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public int insertAccount(Account account) throws Exception {
		return accountDAO.insertAccount(account);
	}

	@Override
	public List<Account> getAccount(String generalId) throws Exception {
		return accountDAO.getAccount(generalId);
	}

	@Override
	public List<AccountTransaction> getAccountTransaction(String accountNumber) throws Exception {
		return accountDAO.getAccountTransaction(accountNumber);
	}

	@Override
	public int deleteAccount(String accountNumber) throws Exception {
		return accountDAO.deleteAccount(accountNumber);
	}


}
