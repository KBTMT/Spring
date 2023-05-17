package com.service.spring.model;

import java.util.Date;
import java.util.List;

import com.service.spring.domain.Board;
import com.service.spring.domain.FinancialInfo;

public interface FinancialInfoDAO {
	List<FinancialInfo> getFinancialInfo(String date) throws Exception;
}
