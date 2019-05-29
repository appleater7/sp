package com.osf.sp.service;

import java.util.List;

import com.osf.sp.vo.ParamVO;
import com.osf.sp.vo.UserInfoVO;

public interface UserInfoService {

	int insertUserInfo(UserInfoVO ui);
	List<UserInfoVO> selectUserInfo();
	int save(ParamVO params);
	UserInfoVO loginById(UserInfoVO ui);
	
}
