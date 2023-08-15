package com.ezen.booktving.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.booktving.dto.BookRegFormDto;
import com.ezen.booktving.service.BookRegService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	private final BookRegService bookRegService;
	
	//도서관리 페이지 보여주기 
	@GetMapping(value = "/admin/book")
	public String adminBook() {
		
		return "admin/adminBook";
	}
	
	//도서등록 페이지 보여주기
	@GetMapping(value = "/admin/bookReg")
	public String adminBoomReg(Model model) {
		
		model.addAttribute("bookRegFormDto", new BookRegFormDto());
		return "admin/adminBookReg";
	}
	
	//도서등록, 도서이미지 등록(insert)
	public String bookInsert(@Valid BookRegFormDto bookRegFormDto, BindingResult bindingResult,
			Model model, @RequestParam("BookImgFile") List<MultipartFile> bookImgFileList) {
		
		if(bindingResult.hasErrors()) {
			return "admin/adminBookReg";
		}
		
		//도서 등록전에 첫번째 이미지가 있는지 없는지 검사(첫번째 이미지는 필수 입력값)
		if(bookImgFileList.get(0).isEmpty()) {
			model.addAttribute("errorMessage", "첫번째 이미지는 필수 등록 하셔야 합니다.");
			return "admin/adminBookReg";
		}
		
		try {
			bookRegService.saveBook(bookRegFormDto, bookImgFileList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "도서등록 도중에 에러가 발생했습니다.");
			return "admin/adminBookReg";
		}
		
		return "redirect:/";
	}
	
	//도서수정 페이지 보여주기
	@GetMapping(value = "/admin/bookModify")
	public String adminBookModify() {
		
		return "admin/adminBookModify";
	}
	
	//회원관리 페이지 보여주기 
	@GetMapping(value = "/admin/member")
	public String adminMemberMng() {
		
		return "admin/adminMemberMng";
	}	
	
	//회원정보 상세페이지 보여주기    //value 경로는 개발하면서 변경. {memberId} 
	@GetMapping(value = "/admin/member/")
	public String adminMemberDetail() {
		
		return "admin/adminMemberDetail";
	}
	
	//대출관리 페이지 보여주기
	@GetMapping(value = "/admin/rent")
	public String adminRent() {
		
		return "admin/adminRent";
	}
	
	//키워드관리 페이지 보여주기
	@GetMapping(value = "/admin/keyword")
	public String adminKeyword() {
		
		return "admin/adminKeyword";
	}
	
	//문의관리 페이지 보여주기
	@GetMapping(value = "/admin/question")
	public String adminQuestion() {
		
		return "admin/adminQuestion";
	}
	
	//문의답변 페이지 보여주기
	@GetMapping(value = "/admin/answer")
	public String adminAnswer() {
		
		return "admin/adminAnswer";
	}
	  
	//공지관리 페이지 보여주기
	@GetMapping(value = "/admin/notice")
	public String adminNotice() {
		
		return "admin/adminNotice";
	}
	
	//공지사항 등록 페이지 보여주기
	@GetMapping(value = "/admin/noticeReg")
	public String adminNoticeReg() {
		
		return "admin/adminNoticeReg";
	}
	
	//공지사항 수정 페이지 보여주기
	@GetMapping(value = "/admin/noticeModify")
	public String adminNoticeModify() {
		
		return "admin/adminNoticeModify";
	}
	
}
