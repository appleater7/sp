package com.osf.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@GetMapping("/test")
	public String goPage1() {
		return "/test";
	}
	
	@GetMapping("/test2")
	public String goPage2() {
		return "/test2";
	}
}