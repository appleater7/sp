package com.osf.sp.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface DeptMapper {

	public List<Map<String, Object>> selectDeptList();
}
