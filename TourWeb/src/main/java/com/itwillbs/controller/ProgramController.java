package com.itwillbs.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/program/*")
public class ProgramController {
	
	// 업로드 파일 경로 servlet.context.xml에서 가져오기
	// <beans:bean id="uploadPath" class="java.lang.String">
	@Resource(name="uploadPath")
	private String uploadPath;

	@GetMapping("/program")
	public String program() {
		System.out.println("ProgramController program()");
		return "program/program";
	}
	
	@GetMapping("/write")
	public String write() {
		System.out.println("ProgramController write()");
		return "program/write";
	}
	
	@PostMapping("/writePro")
	public String writePro(HttpServletRequest request, MultipartFile file) throws Exception {
		System.out.println("ProgramController writePro()");
//		파일 이름 : file.getOriginalFilename();
//		원본 파일 : file.getBytes();
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString() + "_" + file.getOriginalFilename();
		System.out.println("업로드 경로 : " + uploadPath);
		System.out.println("랜덤문자_파일이름 : " + filename);
		FileCopyUtils.copy(file.getBytes(), new File(uploadPath, filename));
		return "redirect:/program/program";
	}
}
