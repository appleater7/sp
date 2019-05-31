package com.osf.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UriController {

	@GetMapping("/views/**")
	public void goPage() {
		
	}
}
