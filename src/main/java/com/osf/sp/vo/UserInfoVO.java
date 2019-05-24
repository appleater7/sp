package com.osf.sp.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ui")
public class UserInfoVO {

	private Integer uiNo;
	private String uiId;
	private String uiPwd;
	private Integer uiAge;
}
