package com.itwillbs.controller;

import java.util.List;

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

@RestController
public class AjaxController {

	@Inject
	private MemberService memberService;
	@Inject
	private BoardService boardService;
	
	
	@GetMapping("/member/idCheck")
	public String idCheck(HttpServletRequest request) {
		System.out.println("AjaxController idCheck()");
		String id = request.getParameter("id");
		MemberDTO memberDTO = memberService.getMember(id);
		String result = "";
		if(memberDTO != null) {
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
	
	
	
	
	
	
	
	
}
