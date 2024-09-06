package com.itwillbs.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberService insertMember()");
		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));
		memberDAO.insertMember(memberDTO);
	}
	
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberService userCheck()");
		return memberDAO.userCheck(memberDTO);
	}
	
	public MemberDTO getMember(String id) {
		System.out.println("MemberService getMember()");
		return memberDAO.getMember(id);
	}
	
	
	
	
	
	
	
	
	
}
