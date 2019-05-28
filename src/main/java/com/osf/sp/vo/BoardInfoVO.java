package com.osf.sp.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("bi")
public class BoardInfoVO {

	private Integer biNum;
	private Integer biType;
	private String biTitle;
	private String biContent;
	private Integer biWriter;
	private Integer biCnt; 
	private String biCredat;
	private String biCretim;
	private Integer biLike;
	private String biPath;
	private MultipartFile biFile;
}
