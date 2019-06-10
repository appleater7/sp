package com.osf.sp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.osf.sp.service.BoardInfoService;
import com.osf.sp.vo.BoardInfoVO;
import com.osf.sp.vo.PageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardInfoController {

	@Resource
	private BoardInfoService bis;
	
	@CrossOrigin(origins="http://localhost")
	@GetMapping("/boardinfos")
	public @ResponseBody PageInfo<BoardInfoVO> selectBoardInfoList(PageVO page){
		log.info("========page info======== : {}",page);

		Page<BoardInfoVO> boardList = bis.selectBoardInfoList(page);
		log.info("boardList=>{}",boardList);
		return new PageInfo<>(boardList);
	}
	
	@CrossOrigin(origins="http://localhost")
	@PostMapping("/boardinfo")
	public @ResponseBody int insertBoardInfo(@RequestBody BoardInfoVO bi){
		return bis.insertBoardInfo(bi); 
	}
	
	@CrossOrigin(origins="http://localhost")
	@GetMapping("/boardinfo")
	public @ResponseBody BoardInfoVO selectBoardInfoByPk(BoardInfoVO bi){
		log.info("bi=>{}",bi);
		return bis.selectBoardInfoByPk(bi); 
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/boardinfof")
	public @ResponseBody int doAdd(BoardInfoVO bi){
		log.info("bi=>{}",bi);
		return bis.insertBoardInfo(bi);
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/boardinfo/{biNum}")
	public @ResponseBody int deleteSample(@PathVariable("biNum") Integer abc){
		return 0;
	}
}