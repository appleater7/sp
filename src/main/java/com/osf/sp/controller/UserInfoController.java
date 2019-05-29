package com.osf.sp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osf.sp.service.UserInfoService;
import com.osf.sp.vo.ParamVO;
import com.osf.sp.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserInfoController {
	
	@Resource
	private UserInfoService us;

	@PostMapping("/userinfo")
	public @ResponseBody int insertUserInfo(@RequestBody UserInfoVO ui){
		log.debug("ui params:{}",ui);
		return us.insertUserInfo(ui);
	}
	
	@PostMapping("/join")
	public @ResponseBody int joinUser(@RequestBody UserInfoVO ui){
		log.debug("ui params:{}",ui);
		return us.insertUserInfo(ui);
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/userinfos")
	public @ResponseBody List<UserInfoVO> selectUserInfo(){
		List<UserInfoVO> uiList = us.selectUserInfo();
		log.debug("ui params:{}",uiList);
		return uiList;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/userinfos")
	public @ResponseBody int saveUserInfo(@RequestBody ParamVO params) {
		log.info("ui params:{}",params);
		return us.save(params);
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/login")
	public @ResponseBody UserInfoVO doLogin(@RequestBody UserInfoVO ui) {
		log.info("params:{}",ui);
		return us.loginById(ui);
	}
}
