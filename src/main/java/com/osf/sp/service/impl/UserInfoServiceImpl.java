package com.osf.sp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osf.sp.mapper.UserInfoMapper;
import com.osf.sp.service.UserInfoService;
import com.osf.sp.vo.ParamVO;
import com.osf.sp.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoMapper uim;
	
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
	public UserInfoVO login(UserInfoVO ui) {
//		UserInfoVO selectUi = uim.selectUserInfoById(ui);
//		if(ui.getUiPwd()!=null) {
//			if(ui.getUiPwd().equals(selectUi.getUiPwd())) {
//				return selectUi;
//			}
//		}
		return uim.selectUserInfoById(ui);
	}

}
