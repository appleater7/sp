package com.osf.sp.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface SalGradeMapper {

	List<Map<String,Object>> selectSalGradeList();
	Map<String,Object> selectSalGrade(Integer grade);
	Integer updateSalGrade(Map<String,String> grades);
	Integer deleteSalGrade(Integer grade);
	Integer insertSalGrade(Map<String,String> grades);
}
