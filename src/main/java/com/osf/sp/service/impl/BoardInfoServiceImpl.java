package com.osf.sp.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.osf.sp.mapper.BoardInfoMapper;
import com.osf.sp.service.BoardInfoService;
import com.osf.sp.vo.BoardInfoVO;
import com.osf.sp.vo.PageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardInfoServiceImpl implements BoardInfoService {

	@Resource
	private BoardInfoMapper bim;
	private final String BASE_PATH = "D:\\study\\springsp\\sp\\src\\main\\webapp\\resources\\imgs\\";
	
	@Override
	public Page<BoardInfoVO> selectBoardInfoList(PageVO page) {
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		return bim.selectBoardInfo(page);
	}

	@Override
	public int insertBoardInfo(BoardInfoVO bi) {
		MultipartFile mf = bi.getBiFile();
		String originName = mf.getOriginalFilename();
		String extName = "";
		if(originName.lastIndexOf(".")!=-1) {
			extName = originName.substring(originName.lastIndexOf("."));
		}
		String fileName = System.currentTimeMillis() + extName;
		log.info("fileName=>{}",fileName);
		File saveFile = new File(BASE_PATH + fileName);
		try {
			Files.copy(mf.getInputStream(), saveFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 앞과정이 정상처리 되었다는 전제조건 하에
		bi.setBiPath("/imgs/" + fileName);
		/*
		if (bim.insertBoardInfo(bi)) {
			원래는 델리트 로직이 들어가야함
		}
		*/
		return bim.insertBoardInfo(bi);
	}

	@Override
	public BoardInfoVO selectBoardInfoByPk(BoardInfoVO bi) {
		
		return bim.selectBoardInfoByPk(bi);
	}	
}
