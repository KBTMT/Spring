package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.model.TestDAO;

@Repository
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SqlSession sqlSession;
}
