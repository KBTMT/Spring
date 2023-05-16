package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.BusinessInfo;
import com.service.spring.domain.TmtUser;
import com.service.spring.model.UserDAO;


@Repository
public class UserDAOImpl implements UserDAO {

	public static final String NS ="sql.tmt.mapper.user.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertUser(TmtUser vo) throws Exception {
		return sqlSession.insert(NS+"insertUser", vo);
	}

	@Override
	public int insertBusiness(BusinessInfo vo) throws Exception {
		return sqlSession.insert(NS+"insertBusiness", vo);
	}

	@Override
	public String idExist(String id) throws Exception {
		return sqlSession.selectOne(NS+"idExist", id);
	}

	@Override
	public int updateUser(TmtUser vo) throws Exception {
		return sqlSession.update(NS+"updateUser", vo);
	}

	@Override
	public int updateBusiness(BusinessInfo vo) throws Exception {
		return sqlSession.update(NS+"updateBusiness", vo);
	}

	@Override
	public int deleteUser(String id) throws Exception {
		return sqlSession.delete(NS+"deleteUser", id);
	}

	@Override
	public int deleteBusiness(String id) throws Exception {
		return sqlSession.delete(NS+"deleteBusiness", id);
	}

	@Override
	public TmtUser login(TmtUser vo) throws Exception {
		return sqlSession.selectOne(NS + "login", vo);
	}

	@Override
	public String getId(TmtUser vo) throws Exception {
		return sqlSession.selectOne(NS + "getId", vo);
	}

	@Override
	public String getPassword(TmtUser vo) throws Exception {
		return sqlSession.selectOne(NS + "getPassword", vo);
	}

	@Override
	public int updatePassword(TmtUser vo) throws Exception {
		return sqlSession.update(NS+"updatePassword", vo);
	}
}
