package com.itwillbs.service;

import javax.inject.Inject;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	
	private MemberDAO memberDAO;
	
	@Inject
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		memberDAO.insertMember(memberDTO);
	}
		
}
