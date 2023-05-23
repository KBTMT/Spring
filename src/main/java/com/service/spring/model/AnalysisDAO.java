package com.service.spring.model;

import java.util.List;
import java.util.Map;

public interface AnalysisDAO {
	public List<Map<String, Object>> getAnalysisByCat(String month) throws Exception;
	public List<Map<String, Object>> getMaxCat(String month) throws Exception;
	public List<Map<String, Object>> getAnalysisByHour(String month) throws Exception;
	public List<Map<String, Object>> sumConsumption(String month) throws Exception;  
	public List<Map<String, Object>> sumIncome(String month) throws Exception;  
}
