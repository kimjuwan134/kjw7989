package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@GetMapping("/insert")
	public String insert() {
		System.out.println("MemberController insert()");
		return "member/insert";
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
		System.out.println(memberDTO);
		if(memberService.userCheck(memberDTO) != null) {
			session.setAttribute("id", memberDTO.getId());
			return "redirect:/member/main";
		}else {
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/main")
	public String main() {
		System.out.println("MemberController main()");
		return "member/main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("MemberController logout()");
		session.invalidate();
		return "redirect:/member/main";
	}
	
	@GetMapping("/info")
	public String info(HttpSession session, Model model) {
		System.out.println("MemberController info()");
		MemberDTO memberDTO = memberService.getMember((String)session.getAttribute("id"));
		model.addAttribute("memberDTO", memberDTO);
		return "member/info";
	}
	
	@GetMapping("/update")
	public String update() {
		System.out.println("MemberController update()");
		return "member/update";
	}
	
	@PostMapping("/updatePro")
	public String updatePro() {
		System.out.println("MemberController updatePro()");
		return "redirect:/member/main";
	}
	
	@GetMapping("/delete")
	public String delete() {
		System.out.println("MemberController delete()");
		return "member/delete";
	}
	
	@PostMapping("/deletePro")
	public String deletePro() {
		System.out.println("MemberController deletePro()");
		return "redirect:/member/main";
	}
	
	@GetMapping("/list")
	public String list() {
		System.out.println("MemberController list()");
		return "member/list";
	}
	
	

}
