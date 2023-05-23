package com.service.spring.model;

import java.util.List;
import java.util.Map;

public interface AnalysisDAO {
	public List<Map<String, Object>> getAnalysisByCat(String generaId) throws Exception;
	public List<Map<String, Object>> getMaxCat(String generaId) throws Exception;
	public List<Map<String, Object>> getAnalysisByHour(String generaId) throws Exception;
	public List<Map<String, Object>> sumConsumption(String generaId) throws Exception;  
	public List<Map<String, Object>> sumIncome(String generaId) throws Exception;  
}
