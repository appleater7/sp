package com.osf.sp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osf.sp.auth.MakeJWT;
import com.osf.sp.mapper.UserInfoMapper;
import com.osf.sp.service.UserInfoService;
import com.osf.sp.vo.ParamVO;
import com.osf.sp.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoMapper uim;
	
	@Resource
	private MakeJWT jwt;
	
	@Override
	public int insertUserInfo(UserInfoVO ui) {

		return uim.insertUserInfo(ui);
	}

	@Override
	public List<UserInfoVO> selectUserInfo() {
		
		return uim.selectUserInfo();
	}

	@Override
	public int save(ParamVO params) {
		int cnt = 0;
		List<Integer> duiNos = params.getDelUiNos();
		for (int uiNo :duiNos) {
			cnt += uim.deleteUserInfo(uiNo);
		}
		List<UserInfoVO> addUis = params.getAddUis();
		for(UserInfoVO ui:addUis) {
			cnt += uim.insertUserInfo(ui);
		}
		List<UserInfoVO> modiUis = params.getModiUis();
		for(UserInfoVO ui:modiUis) {
			cnt += uim.updateUserInfo(ui);
		}
		return cnt;
	}

	@Override
	public UserInfoVO loginById(UserInfoVO ui) {
		UserInfoVO dbUi = uim.selectUserInfoById(ui);
		if (ui.getUiId().equals(dbUi.getUiId())) {
			if (ui.getUiPwd().equals(dbUi.getUiPwd())) {
				ui.setTokken(jwt.makeJWT(ui));
				return ui;
			}
		}		
		return dbUi;
	}



}
