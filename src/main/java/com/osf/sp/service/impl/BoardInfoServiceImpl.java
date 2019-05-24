package com.osf.sp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osf.sp.mapper.BoardInfoMapper;
import com.osf.sp.service.BoardInfoService;
import com.osf.sp.vo.BoardInfoVO;

@Service
public class BoardInfoServiceImpl implements BoardInfoService {

	@Resource
	private BoardInfoMapper bim;
	
	@Override
	public List<BoardInfoVO> selectBoardInfoList() {

		return bim.selectBoardInfo();
	}

	@Override
	public int insertBoardInfo(BoardInfoVO bi) {
		
		return bim.insertBoardInfo(bi);
	}

	@Override
	public BoardInfoVO selectBoardInfoByPk(BoardInfoVO bi) {
		
		return bim.selectBoardInfoByPk(bi);
	}	
}
