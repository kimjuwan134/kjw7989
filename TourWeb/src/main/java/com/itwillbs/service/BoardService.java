package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("BoardService insertBoard()");
		boardDTO.setNum(boardDAO.getMaxNum() + 1);
		boardDTO.setReadCount(0);
		boardDTO.setDate(new Timestamp(System.currentTimeMillis()));
		boardDAO.insertBoard(boardDTO);;
	}

	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		System.out.println("BoardService getBoardList()");
		int startRow = (pageDTO.getCurrentPage() - 1) * pageDTO.getPageSize() + 1;
		int endRow = startRow + pageDTO.getPageSize() - 1;
//		               limit 시작하는 행번호 - 1, 글개수
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		return boardDAO.getBoardList(pageDTO);
	}

	public int getBoardCount(PageDTO pageDTO) {
		System.out.println("BoardService getBoardCount()");
		return boardDAO.getBoardCount(pageDTO);
	}
	
}
