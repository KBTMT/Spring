package com.service.spring.model;

import java.util.List;
import java.util.Map;

import com.service.spring.domain.AccountBook;

public interface AccountBookService {
	List<Map<String, Object>> getStat(String generalId) throws Exception;
	
	List<AccountBook> getAccountBook(String generalId) throws Exception;
	
	int registerAccountBook(AccountBook accountBook) throws Exception;
	
	int updateAccountBook(AccountBook accountBook) throws Exception;
	
	int shareAccountBook(AccountBook accountBook)throws Exception;
	
	int deleteAccountBook(long accountBookSeq) throws Exception;
	
	List<AccountBook> dailyAccountBook(String time) throws Exception;
	
	long checkIsUsed(AccountBook accountBook) throws Exception;
}
