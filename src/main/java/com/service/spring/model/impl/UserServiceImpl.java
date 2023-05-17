package com.service.spring.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.BusinessInfo;
import com.service.spring.domain.TmtUser;
import com.service.spring.model.UserDAO;
import com.service.spring.model.UserService;

@Service
public class UserServiceImpl implements UserService{
 
	@Autowired
	private UserDAO userDAO;

	@Override
	public int insertUser(TmtUser vo) throws Exception {
		return userDAO.insertUser(vo);
	}

	@Override
	public int insertBusiness(BusinessInfo vo) throws Exception {
		return userDAO.insertBusiness(vo);
	}

	@Override
	public String idExist(String id) throws Exception {
		return userDAO.idExist(id);
	}

	@Override
	public int updateUser(TmtUser vo) throws Exception {
		return userDAO.updateUser(vo);
	}

	@Override
	public int updateBusiness(BusinessInfo vo) throws Exception {
		return userDAO.updateBusiness(vo);
	}

	@Override
	public int deleteUser(String id) throws Exception {
		return userDAO.deleteUser(id);
	}

	@Override
	public int deleteBusiness(String id) throws Exception {
		return userDAO.deleteBusiness(id);
	}

	@Override
	public TmtUser login(TmtUser vo) throws Exception {
		return userDAO.login(vo);
	}

	@Override
	public String getId(TmtUser vo) throws Exception {
		return userDAO.getId(vo);
	}

	@Override
	public String getPassword(TmtUser vo) throws Exception {
		return userDAO.getPassword(vo);
	}

	@Override
	public int updatePassword(TmtUser vo) throws Exception {
		return userDAO.updatePassword(vo);
	}

	@Override
	public String nicknameExist(String userNickname) throws Exception {
		return userDAO.nicknameExist(userNickname);
	}
}
