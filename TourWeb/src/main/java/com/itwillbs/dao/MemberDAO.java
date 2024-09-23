package com.itwillbs.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.itwillbs.mapper.MemberMapper";

//	public void insertMember(MemberDTO memberDTO) {
//		System.out.println("MemberDAO insertMember()");
//		sqlSession.insert(namespace + ".insertMember", memberDTO);
//	}
	
	public void insertMember(Map<String, String> memberMap) {
		System.out.println("MemberDAO insertMember()");
		sqlSession.insert(namespace + ".insertMember", memberMap);
	}
	
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberDAO userCheck()");
		return sqlSession.selectOne(namespace + ".userCheck", memberDTO);
	}

	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO updateMember()");
		sqlSession.update(namespace + ".updateMember", memberDTO);
	}

//	public MemberDTO getMember(String id) {
//		System.out.println("MemberDAO getMember()");
//		return sqlSession.selectOne(namespace + ".getMember", id);
//	}
	
	public Map<String, Object> getMember(String id) {
		System.out.println("MemberDAO getMember()");
		return sqlSession.selectOne(namespace + ".getMember", id);
	}
	
}
