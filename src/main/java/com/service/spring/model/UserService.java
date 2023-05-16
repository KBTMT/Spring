package com.service.spring.model;

import com.service.spring.domain.BusinessInfo;
import com.service.spring.domain.TmtUser;

public interface UserService {
	int insertUser(TmtUser vo) throws Exception;
	int insertBusiness(BusinessInfo vo) throws Exception;
	String idExist(String id) throws Exception;
	int updateUser(TmtUser vo) throws Exception;
	int updateBusiness(BusinessInfo vo) throws Exception;
	int deleteUser(String id) throws Exception;
	int deleteBusiness(String id) throws Exception;
	TmtUser login(TmtUser vo) throws Exception;
	String getId(TmtUser vo) throws Exception;
	String getPassword(TmtUser vo) throws Exception;
	int updatePassword(TmtUser vo) throws Exception;
}
