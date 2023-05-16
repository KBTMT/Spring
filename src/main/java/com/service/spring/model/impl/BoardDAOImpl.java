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
import com.service.spring.model.BoardDAO;
import com.service.spring.model.TestDAO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
//	Reader r = Resources.getResourceAsReader("../../../../../../../../src/main/resources/config/SqlMapConfig.xml");
//	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
//	SqlSession session = factory.openSession();
//	
	public static final String NS = "sql.tmt.mapper.";

	@Override
	public int insertBoard(Board pvo) throws Exception {
		return sqlSession.insert(NS + "insertBoard", pvo);
	}

	@Override
	public Board getBoard(long boardSeq) throws Exception {
		return sqlSession.selectOne(NS + "getBoard", boardSeq);
	}

	@Override
	public List<Board> getBoard() throws Exception {
		System.out.println("dao");
		return  sqlSession.selectList(NS+"getAllBoard");
	}

//	@Override
//	public List<Board> getBoard(String userNickname) throws Exception {
//		return sqlSession.selectList(NS+"getAllBoard");
//	}

	@Override
	public List<Board> getBoard(String generalId) throws Exception {
		return sqlSession.selectList(NS+"getBoardbyGeneralId",generalId);
	}

	@Override
	public List<Board> getBoard(Date startDate, Date endDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(Board pvo) throws Exception {
		return sqlSession.update(NS + "updateBoard", pvo);
	}

	@Override
	public int deleteBoard(long boardSeq) throws Exception {
		return sqlSession.delete(NS + "deleteBoard", boardSeq);
	}

}
