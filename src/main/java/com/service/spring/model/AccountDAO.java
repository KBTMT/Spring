package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Account;
import com.service.spring.domain.AccountTransaction;

public interface AccountDAO {
	int insertAccount(Account account)  throws Exception;
	
	List<Account> getAccount(String generalId) throws Exception;
	
	List<AccountTransaction> getAccountTransaction(String accountNumber) throws Exception;

	int deleteAccount(String accountNumber)  throws Exception;
	
}
    