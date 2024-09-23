package com.itwillbs.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberService {
	
	@Inject
	private MemberDAO memberDAO;

//	public void insertMember(MemberDTO memberDTO) {
//		System.out.println("MemberService insertMember()");
//		memberDTO.setEmail(memberDTO.getEmail() + "@" + memberDTO.getEmail2());
//		if(memberDTO.getAgree() == null) {
//			memberDTO.setAgree("disagree");
//		}
//		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));
//		memberDAO.insertMember(memberDTO);
//	}
	
	public void insertMember(Map<String, String> memberMap) {
		System.out.println("MemberService insertMember()");
		memberMap.put("email",memberMap.get("email") + "@" + memberMap.get("email2"));
		if(memberMap.get("agree") == null) {
			memberMap.put("agree", "disagree");
		}
//		memberMap.put("date", new SimpleDateFormat(new Timestamp(System.currentTimeMillis()), "yyyy-MM-dd").toString());
		memberDAO.insertMember(memberMap);
	}
	
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberService userCheck()");
		return memberDAO.userCheck(memberDTO);
	}

	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberService updateMember()");
		memberDAO.updateMember(memberDTO);
	}

	public Map<String, Object> getMember(String id) {
		System.out.println("MemberService getMember()");
		return memberDAO.getMember(id);
	}
	
	
}
