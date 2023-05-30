package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.BComment;
import com.service.spring.model.BCommentDAO;

@Repository
public class BCommentDAOImpl implements BCommentDAO {

	@Autowired
	private SqlSession sqlSession;
	static final String NS = "sql.tmt.mapper.";

	@Override
	public int insertBComment(BComment pvo) throws Exception {
		return sqlSession.insert(NS + "insertBComment", pvo);
	}

	@Override
	public List<BComment> getBComment() throws Exception {
		return sqlSession.selectList(NS + "getALLComment");
	}

	@Override
	public List<BComment> getBComment(long boardSeq) throws Exception {
		return sqlSession.selectList(NS + "getBComment", boardSeq);
	}

	@Override
	public int updateBComment(BComment pvo) throws Exception {
		return sqlSession.update(NS + "updateBComment", pvo);
	}

	@Override
	public int deleteBComment(long commentSeq) throws Exception {
		return sqlSession.update(NS + "deleteBComment", commentSeq);
	}

	@Override
	public BComment getBCommentbySeq(long commentSeq) throws Exception {
		return sqlSession.selectOne(NS + "getComment", commentSeq);
	}
}
