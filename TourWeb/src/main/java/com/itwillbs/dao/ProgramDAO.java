package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Repository
public class ProgramDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.itwillbs.mapper.ProgramMapper";
	
	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("ProgramDAO insertBoard()");
		sqlSession.insert(namespace + ".insertBoard", boardDTO);		
	}

	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		System.out.println("ProgramDAO getBoardList()");
		return sqlSession.selectList(namespace + ".getBoardList", pageDTO);
	}

	public int getBoardCount() {
		System.out.println("ProgramDAO getBoardCount()");
		return sqlSession.selectOne(namespace + ".getBoardCount");
	}

	public BoardDTO getBoard(int num) {
		System.out.println("ProgramDAO getBoard()");
		return sqlSession.selectOne(namespace + ".getBoard", num);
	}

	public void updateBoard(BoardDTO boardDTO) {
		System.out.println("ProgramDAO updateBoard()");
		sqlSession.update(namespace + ".updateBoard", boardDTO);
	}
	
	
}
