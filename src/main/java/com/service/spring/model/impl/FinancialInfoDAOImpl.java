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

import com.service.spring.domain.FinancialInfo;
import com.service.spring.model.FinancialInfoDAO;
import com.service.spring.model.TestDAO;

@Repository
public class FinancialInfoDAOImpl implements FinancialInfoDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "sql.tmt.mapper.";

	@Override
	public List<FinancialInfo> getFinancialInfo(String date) throws Exception {
		return sqlSession.selectList(NS+"getFinancialInfo");
	}

	
}
