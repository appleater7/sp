package com.osf.sp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osf.sp.service.SalGradeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SalGradeController {

	@Resource
	private SalGradeService sgs;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/salgrades")
	public @ResponseBody List<Map<String, Object>> selectSalGrades() {
		log.info("selectSalGrades =>{}",sgs.selectSalGradeList());
		return sgs.selectSalGradeList();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/salgrade")
	public @ResponseBody Map<String, Object> selectSalGrade(@RequestParam Map<String,Object> grades) {
		log.info("grade=>{}",grades);
		Integer grade = Integer.parseInt((String)grades.get("grade"));
		return sgs.selectSalGrade(grade);
	}
	
	@PutMapping("/salgrade")
	public @ResponseBody Integer updateSalGrade(@RequestBody Map<String,String> grades){
		log.info("grades=>{}",grades);
		return sgs.updateSalGrade(grades);
	}
	
	@DeleteMapping("/salgrade")
	public @ResponseBody Integer deleteSalGrade(@RequestBody Map<String,Object> grades) {
		log.info("grades=>{}",grades);
		Integer grade = Integer.parseInt((String)grades.get("grade"));
		return sgs.deleteSalGrade(grade);
	}
	
	@PostMapping("/salgrade")
	public @ResponseBody Integer insertSalGrade(@RequestBody Map<String,String> grades){
		log.info("grades=>{}",grades);
		return sgs.insertSalGrade(grades);
	}	
}
