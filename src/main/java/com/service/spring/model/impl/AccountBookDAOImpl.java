package com.service.spring.model.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.AccountBook;
import com.service.spring.model.AccountBookDAO;

@Repository
public class AccountBookDAOImpl implements AccountBookDAO{

	@Autowired
	private SqlSession sqlSession;
	
	public static final String MAPPER_NAME = "sql.tmt.mapper.cha.";

	@Override
	public List<AccountBook> getAccountBook(String generalId) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"getAccountBook", generalId);
	}


	@Override
	public int registerAccountBook(AccountBook accountBook) throws Exception {	
		int result = sqlSession.insert(MAPPER_NAME+"registerAccountBook", accountBook);
		sqlSession.commit();
		return result;
	}

	@Override
	public int updateAccountBook(AccountBook accountBook) throws Exception {		
		return sqlSession.update(MAPPER_NAME+"updateAccountBook", accountBook);
	}
	
	public int deleteAccountBook(long accountBookSeq) throws Exception{
		return sqlSession.delete(MAPPER_NAME+"deleteAccountBook", accountBookSeq);
	}

	@Override
	public int shareAccountBook(AccountBook accountBook) throws Exception {	
		return 0;
	}

	@Override
	public List<AccountBook> dailyAccountBook(String time) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"dailyAccountBook", time);
	}

	@Override
	public List<Map<String, Object>> getStat(String generalId) throws Exception {
		List<Map<String, Object>> s = sqlSession.selectList(MAPPER_NAME+"getStat", generalId);
		System.out.println(s);
		return sqlSession.selectList(MAPPER_NAME+"getStat", generalId);
	}


	@Override
	public long checkIsUsed(AccountBook accountBook) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"checkIsUsed", accountBook);
	}

}
