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

import com.service.spring.domain.Board;
import com.service.spring.domain.DCMypick;
import com.service.spring.model.BoardDAO;
import com.service.spring.model.DCMypickDAO;
import com.service.spring.model.TestDAO;

@Repository
public class DCMypickDAOImpl implements DCMypickDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "sql.tmt.mapper.mypick.";

	@Override
	public int insertDCMypick(DCMypick dCMypick) throws Exception {
		return sqlSession.insert(NS+"insertDCMypick", dCMypick);
	}

	@Override
	public int updateUsedPick(DCMypick dCMypick) throws Exception {
		return sqlSession.update(NS+"updateUsedPick", dCMypick);
	}

	@Override
	public int deleteDCMypick(DCMypick dCMypick) throws Exception {
		return sqlSession.delete(NS+"deleteDCMypick", dCMypick);
	}

	@Override
	public List<DCMypick> getDCMypick(String generalId) throws Exception {
		return sqlSession.selectList(NS+"getMyDCPick", generalId);
	}

	@Override
	public List<DCMypick> getDCMypickUsed(String generalId) throws Exception {
		return sqlSession.selectList(NS+"getDCMypickUsed", generalId);
	}

	
}
