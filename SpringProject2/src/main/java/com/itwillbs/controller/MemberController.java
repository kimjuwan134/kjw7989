package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@GetMapping("/member/insert")
	public String insert() {
		System.out.println("MemberController insert()");
		return "member/insert";
	}
	
	@PostMapping("/member/insertPro")
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		System.out.println(memberDTO);
		memberService.insertMember(memberDTO);
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/login")
	public String login() {
		System.out.println("MemberController login()");
		return "member/login";
	}
	
	@PostMapping("/member/loginPro")
	public String loginPro() {
		System.out.println("MemberController loginPro()");
		return "redirect:/member/main";
	}
	
	@GetMapping("/member/main")
	public String main() {
		System.out.println("MemberController main()");
		return "member/main";
	}
	
	
	
}
