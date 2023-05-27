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

	@Override
	public long getCountLike(long discountSeq) throws Exception {
		return dCMypickDAO.getCountLike(discountSeq);
	}

	@Override
	public DCMypick isExist(DCMypick dCMypick) throws Exception {
		return dCMypickDAO.isExist(dCMypick);
	}

	@Override
	public List<DCMypick> getReviews(long discountSeq) throws Exception {
		return dCMypickDAO.getReviews(discountSeq);
	}

	@Override
	public int usedPickInAccountBook(DCMypick dCMypick) throws Exception {
		return dCMypickDAO.usedPickInAccountBook(dCMypick);
	}
	
}
