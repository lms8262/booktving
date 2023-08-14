package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	//도서관리 페이지 보여주기 
	@GetMapping(value = "/admin/book")
	public String adminBook() {
		
		return "admin/adminBook";
	}
	
	//도서등록 페이지 보여주기
	@GetMapping(value = "/admin/bookReg")
	public String adminBoomReg() {
		
		return "admin/adminBookReg";
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
