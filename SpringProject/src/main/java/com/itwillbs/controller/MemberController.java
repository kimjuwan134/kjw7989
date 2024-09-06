package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;
import com.itwillbs.service.MemberServiceImpl2;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@Inject
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
//	@Inject
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}

	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		System.out.println("MemberController insert()");
		return "member/insert";
	}
	
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		System.out.println(memberDTO);
		memberService.insertMember(memberDTO);
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("MemberController login()");
		return "member/login";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("MemberController loginPro()");
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		System.out.println("MemberController main()");
		return "member/main";
	}
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info() {
		System.out.println("MemberController info()");
		return "member/info";
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		System.out.println("MemberController delete()");
		return "member/delete";
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list() {
		System.out.println("MemberController list()");
		return "member/list";
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout() {
		System.out.println("MemberController logout()");
		return "member/logout";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		System.out.println("MemberController update()");
		return "member/update";
	}
	
}
