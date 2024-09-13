package com.itwillbs.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.ProgramService;

@Controller
@RequestMapping("/program/*")
public class ProgramController {
	
	@Inject
	private ProgramService programService;
	
	// 업로드 파일 경로 servlet.context.xml에서 가져오기
	// <beans:bean id="uploadPath" class="java.lang.String">
	@Resource(name="uploadPath")
	private String uploadPath;

	@GetMapping("/program")
	public String program(HttpServletRequest request, Model model) {
		System.out.println("ProgramController program()");
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 12;
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setPageSize(pageSize);
		
		int count = programService.getBoardCount();
		// 한 화면에 보여줄 페이지 개수
		int pageBlock = 5;
		// 시작하는 페이지 번호
		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		// 끝 페이지 번호
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지 개수
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		if(endPage > pageCount) {
			endPage = pageCount; 
		}
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		List<BoardDTO> boardList = programService.getBoardList(pageDTO);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
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
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setName(request.getParameter("name"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setContent(request.getParameter("content"));
		String s1 = request.getParameter("startDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = (Date)format.parse(s1); 
		boardDTO.setStartDate(d1);
		String s2 = request.getParameter("endDate");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date d2 = (Date)format2.parse(s2); 
		boardDTO.setEndDate(d2);
		boardDTO.setFile(filename);
		programService.insertBoard(boardDTO);
		return "redirect:/program/program";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("num") int num, Model model) {
		System.out.println("ProgramController update()");
 		BoardDTO boardDTO = programService.getBoard(num);
 		model.addAttribute("boardDTO", boardDTO);
		return "program/update";
	}
	
	@PostMapping("/updatePro")
	public String updatePro(HttpServletRequest request, MultipartFile file) throws Exception {
		System.out.println("ProgramController updatePro()");
//		파일 이름 : file.getOriginalFilename();
//		원본 파일 : file.getBytes();
		String filename = "";
		if(file.isEmpty()) {
			filename = request.getParameter("oldfile");
		}else {
			UUID uuid = UUID.randomUUID();
			filename = uuid.toString() + "_" + file.getOriginalFilename();
			System.out.println("업로드 경로 : " + uploadPath);
			System.out.println("랜덤문자_파일이름 : " + filename);
			FileCopyUtils.copy(file.getBytes(), new File(uploadPath, filename));
			File oldfile = new File(uploadPath, request.getParameter("oldfile"));
			if(oldfile.exists()) {
				oldfile.delete();
			}
		}
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(Integer.parseInt(request.getParameter("num")));
		boardDTO.setName(request.getParameter("name"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setContent(request.getParameter("content"));
		String s1 = request.getParameter("startDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = (Date)format.parse(s1); 
		boardDTO.setStartDate(d1);
		String s2 = request.getParameter("endDate");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date d2 = (Date)format2.parse(s2); 
		boardDTO.setEndDate(d2);
		boardDTO.setFile(filename);
		programService.updateBoard(boardDTO);
		return "redirect:/program/program";
	}
	
}
