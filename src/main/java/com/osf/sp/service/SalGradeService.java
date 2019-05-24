package com.osf.sp.service;

import java.util.List;
import java.util.Map;

public interface SalGradeService {
	
	public List<Map<String,Object>> selectSalGradeList();
	public Map<String,Object> selectSalGrade(Integer grade);
	public Integer updateSalGrade(Map<String,String> grades);
	public Integer deleteSalGrade(Integer grade);
	public Integer insertSalGrade(Map<String,String> grades);

}
