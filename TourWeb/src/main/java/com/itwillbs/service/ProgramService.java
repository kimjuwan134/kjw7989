package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.ProgramDAO;
import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class ProgramService {
	
	@Inject
	private ProgramDAO programDAO;
	
	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("ProgramService insertBoard()");
		boardDTO.setReadCount(0);
		boardDTO.setDate(new Timestamp(System.currentTimeMillis()));
		programDAO.insertBoard(boardDTO);
	}

	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		System.out.println("ProgramService getBoardList()");
		int startRow = (pageDTO.getCurrentPage() - 1) * pageDTO.getPageSize() + 1;
		int endRow = startRow + pageDTO.getPageSize() - 1;
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		return programDAO.getBoardList(pageDTO);
	}

	public int getBoardCount() {
		System.out.println("ProgramService getBoardCount()");
		return programDAO.getBoardCount();
	}

	public BoardDTO getBoard(int num) {
		System.out.println("ProgramService getBoard()");
		return programDAO.getBoard(num);
	}

	public void updateBoard(BoardDTO boardDTO) {
		System.out.println("ProgramService updateBoard()");
		programDAO.updateBoard(boardDTO);
	}

}
