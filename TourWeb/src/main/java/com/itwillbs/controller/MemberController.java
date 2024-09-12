package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	
	@GetMapping("/insert")
	public String insert() {
		System.out.println("MemberController insert()");
		return "member/join";
	}
	
	@PostMapping("/insertPro")
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		System.out.println(memberDTO);
		memberService.insertMember(memberDTO);
		return "redirect:/member/login";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("MemberController login()");
		return "member/login";
	}
	
	@PostMapping("/loginPro")
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController loginPro()");
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		if(memberDTO2 != null) {
			session.setAttribute("id", memberDTO2.getId());
			return "redirect:/member/main";
		}else {
			return "member/msg";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("MemberController logout()");
		session.invalidate();
		return "redirect:/member/main";
	}
	
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		System.out.println("MemberController update()");
		String id = (String)session.getAttribute("id");
		MemberDTO memberDTO = memberService.getMember(id);
		model.addAttribute("memberDTO", memberDTO);
		return "member/update";
	}
	
	@PostMapping("/updatePro")
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro()");
		if(memberService.userCheck(memberDTO) != null) {
			memberService.updateMember(memberDTO);
			return "redirect:/member/main";
		}else {
			return "member/msg";
		}
	}
	
	@GetMapping("/main")
	public String main() {
		System.out.println("MemberController main()");
		return "main/main";
	}
	
	
	
	
	
}
