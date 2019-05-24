package com.osf.sp.vo;

import java.util.List;

import lombok.Data;

@Data
public class ParamVO {

	private List<Integer> delUiNos;
	private List<UserInfoVO> addUis;
	private List<UserInfoVO> modiUis;
}
