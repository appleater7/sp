package com.osf.sp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osf.sp.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DeptController {

	@Resource
	private DeptService ds;
	
	@CrossOrigin(origins="*")
	@GetMapping("/depts")
	public @ResponseBody List<Map<String,Object>> getDepts(){
		log.info("DeptList=>{}",ds.selectDeptList());
		return ds.selectDeptList();
	}
}
