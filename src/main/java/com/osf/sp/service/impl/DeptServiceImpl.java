package com.osf.sp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osf.sp.mapper.DeptMapper;
import com.osf.sp.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Resource
	private DeptMapper dm;

	@Override
	public List<Map<String, Object>> selectDeptList() {
		// TODO Auto-generated method stub
		return dm.selectDeptList();
	}

}
