package com.service.spring.model.impl;

import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Account;
import com.service.spring.domain.AccountTransaction;
import com.service.spring.domain.Board;
import com.service.spring.model.AccountDAO;
import com.service.spring.model.BoardDAO;
import com.service.spring.model.TestDAO;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "sql.tmt.mapper.account.";
	
	@Override
	public int insertAccount(Account account) throws Exception {
		return sqlSession.insert(NS+"insertAccount", account);
	}

	@Override
	public List<Account> getAccount(String generalId) throws Exception {
		return sqlSession.selectList(NS+"getAccount", generalId);
	}

	@Override
	public int deleteAccount(String accountNumber) throws Exception {
		return sqlSession.delete(NS+"accountNumber", accountNumber);
	}
	@Override
	public List<AccountTransaction> getAccountTransaction(String accountNumber) throws Exception {
		return sqlSession.selectList(NS+"getAccountTransaction", accountNumber);
	}

}
