package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("BoardController list()");
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		// 검색어 가져오기
		String search = request.getParameter("search");
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setPageSize(pageSize);
		pageDTO.setSearch(search);
		List<BoardDTO> boardList = boardService.getBoardList(pageDTO);
		
		// 검색어 포함
		int count = boardService.getBoardCount(pageDTO);
			
		// 한 화면에 보여줄 페이지 개수
		int pageBlock = 5;
		
		// 시작하는 페이지 번호
		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		
		// 끝나는 페이지 번호
		int endPage = startPage + pageBlock - 1;
		
		// 전체 글갯수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		
		// endPage 전체 글갯수 비교 => endPage 크면 전체 글갯수 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		return "notice/notice";
	}
	
	@GetMapping("/content")
	public String content() {
		System.out.println("BoardController content()");
		return "notice/content";
	}
		
	@GetMapping("/write")
	public String write() {
		System.out.println("BoardController write()");
		return "notice/write";
	}
	
	@PostMapping("/writePro")
	public String writePro(BoardDTO boardDTO) {
		System.out.println("BoardController writePro()");
		System.out.println(boardDTO);
		boardService.insertBoard(boardDTO);
		return "redirect:/board/list";
	}
	
}
