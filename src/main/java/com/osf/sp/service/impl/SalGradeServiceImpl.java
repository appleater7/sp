package com.osf.sp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osf.sp.mapper.SalGradeMapper;
import com.osf.sp.service.SalGradeService;

@Service
public class SalGradeServiceImpl implements SalGradeService {
	
	@Resource
	private SalGradeMapper sgm;

	@Override
	public List<Map<String, Object>> selectSalGradeList() {
		return sgm.selectSalGradeList();
	}

	@Override
	public Map<String,Object> selectSalGrade(Integer grade) {
		return sgm.selectSalGrade(grade);
	}

	@Override
	public Integer updateSalGrade(Map<String, String> grades) {
		return sgm.updateSalGrade(grades);
	}

	@Override
	public Integer deleteSalGrade(Integer grade) {
		return sgm.deleteSalGrade(grade);
	}

	@Override
	public Integer insertSalGrade(Map<String, String> grades) {
		return sgm.insertSalGrade(grades);
	}
}
