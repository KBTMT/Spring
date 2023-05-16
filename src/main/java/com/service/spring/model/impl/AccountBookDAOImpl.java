package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.service.spring.domain.AccountBook;
import com.service.spring.model.AccountBookDAO;

public class AccountBookDAOImpl implements AccountBookDAO{

	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "tmt_query_cha.";
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<AccountBook> getAccountBook(String generalId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(MAPPER_NAME+"getAccountBook", generalId);
	}


	@Override
	public int registerAccountBook(AccountBook accountBook) throws Exception {
		// TODO Auto-generated method stub
		int result = sqlSession.insert(MAPPER_NAME+"registerAccountBook", accountBook);
		sqlSession.commit();
		return result;
	}

	@Override
	public int updateAccountBook(AccountBook accountBook) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(MAPPER_NAME+"updateAccountBook", accountBook);
	}
	
	public int deleteAccountBook(long accountBookSeq) throws Exception{
		return sqlSession.delete(MAPPER_NAME+"deleteAccountBook", accountBookSeq);
	}

	@Override
	public int shareAccountBook(AccountBook accountBook) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccountBook> dailyAccountBook(String time) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(MAPPER_NAME+"dailyAccountBook", time);
	}

}
