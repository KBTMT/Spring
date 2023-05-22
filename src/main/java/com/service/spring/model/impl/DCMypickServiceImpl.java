package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.DCMypick;
import com.service.spring.model.DCMypickDAO;
import com.service.spring.model.DCMypickService;

@Repository
public class DCMypickServiceImpl implements DCMypickService {

	@Autowired
	private DCMypickDAO dCMypickDAO;

	@Override
	public int insertDCMypick(DCMypick dCMypick) throws Exception {
		return dCMypickDAO.insertDCMypick(dCMypick);
	}

	@Override
	public int updateUsedPick(DCMypick dCMypick) throws Exception {
		return dCMypickDAO.updateUsedPick(dCMypick);
	}

	@Override
	public List<DCMypick> getDCMypick(String generalId) throws Exception {
		return dCMypickDAO.getDCMypick(generalId);
	}

	@Override
	public int deleteDCMypick(DCMypick dCMypick) throws Exception {
		return dCMypickDAO.deleteDCMypick(dCMypick);
	}

	@Override
	public List<DCMypick> getDCMypickUsed(String generalId) throws Exception {
		return dCMypickDAO.getDCMypickUsed(generalId);
	}
	
}
