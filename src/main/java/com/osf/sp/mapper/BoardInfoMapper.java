package com.osf.sp.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.github.pagehelper.Page;
import com.osf.sp.vo.BoardInfoVO;
import com.osf.sp.vo.PageVO;

@MapperScan
public interface BoardInfoMapper {

	public Page<BoardInfoVO> selectBoardInfo(PageVO page);
	public int insertBoardInfo(BoardInfoVO bi);
	public BoardInfoVO selectBoardInfoByPk(BoardInfoVO bi);
}