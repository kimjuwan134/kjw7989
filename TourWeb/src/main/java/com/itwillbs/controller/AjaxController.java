package com.itwillbs.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.BoardService;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.ProgramService;

@RestController
public class AjaxController {

	@Inject
	private MemberService memberService;
	@Inject
	private BoardService boardService;
	@Inject
	private ProgramService programService;
	
	
	@GetMapping("/member/idCheck")
	public String idCheck(HttpServletRequest request) {
		System.out.println("AjaxController idCheck()");
		String id = request.getParameter("id");
		Map<String, Object> memberMap = memberService.getMember(id);
		String result = "";
		if(memberMap != null) {
			result = "iddup";
		}else {
			result = "idok";
		}
		return result;
	}
	
	@GetMapping("/board/listjson")
	public List<BoardDTO> listjson() {
		System.out.println("AjaxController listjson()");
		int pageSize = 5;
		String pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		List<BoardDTO> boardList = boardService.getBoardList(pageDTO);
		return boardList;
	}
	
	@GetMapping("/program/listjson")
	public List<BoardDTO> listjson2() {
		System.out.println("AjaxController listjson2()");
		int pageSize = 5;
		String pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		List<BoardDTO> boardList = programService.getBoardList(pageDTO);
		return boardList;
	}
	
	
	
	
	
	
	
	
}
