package com.osf.sp.service;

import java.util.List;

import com.osf.sp.vo.BoardInfoVO;

public interface BoardInfoService {

	public List<BoardInfoVO> selectBoardInfoList();
	public int insertBoardInfo(BoardInfoVO bi);
	public BoardInfoVO selectBoardInfoByPk(BoardInfoVO bi);
}
