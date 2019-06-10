package com.osf.sp.service;

import com.github.pagehelper.Page;
import com.osf.sp.vo.BoardInfoVO;
import com.osf.sp.vo.PageVO;

public interface BoardInfoService {

	public Page<BoardInfoVO> selectBoardInfoList(PageVO page);
	public int insertBoardInfo(BoardInfoVO bi);
	public BoardInfoVO selectBoardInfoByPk(BoardInfoVO bi);
}
