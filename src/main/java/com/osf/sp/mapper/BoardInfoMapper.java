package com.osf.sp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.osf.sp.vo.BoardInfoVO;

@MapperScan
public interface BoardInfoMapper {

	public List<BoardInfoVO> selectBoardInfo();
	public int insertBoardInfo(BoardInfoVO bi);
	public BoardInfoVO selectBoardInfoByPk(BoardInfoVO bi);
}