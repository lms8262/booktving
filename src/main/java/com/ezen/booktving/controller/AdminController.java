package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	//도서관리 페이지 보여주기 
	@GetMapping(value = "/adminBook")
	public String adminBook() {
		
		return "admin/adminBook";
	}
	
	//도서등록 페이지 보여주기
	@GetMapping(value = "/adminBookReg")
	public String adminBoomReg() {
		
		return "admin/adminBookReg";
	}
	
	//도서수정 페이지 보여주기
	@GetMapping(value = "/adminBookModify")
	public String adminBookModify() {
		
		return "admin/adminBookModify";
	}
	
	//회원관리 페이지 보여주기 
	@GetMapping(value = "/adminMember")
	public String adminMemberMng() {
		
		return "admin/adminMemberMng";
	}	
	
	//회원정보 상세페이지 보여주기    //value 경로는 개발하면서 변경. {memberId} 
	@GetMapping(value = "/adminMember/")
	public String adminMemberDetail() {
		
		return "admin/adminMemberDetail";
	}
	
	//대출관리 페이지 보여주기
	@GetMapping(value = "/adminRent")
	public String adminRent() {
		
		return "admin/adminRent";
	}
	
	//키워드관리 페이지 보여주기
	@GetMapping(value = "/adminKeyword")
	public String adminKeyword() {
		
		return "admin/adminKeyword";
	}
	
	//문의관리 페이지 보여주기
	@GetMapping(value = "/adminQuestion")
	public String adminQuestion() {
		
		return "admin/adminQuestion";
	}
	
	//문의답변 페이지 보여주기
	@GetMapping(value = "/adminAnswer")
	public String adminAnswer() {
		
		return "admin/adminAnswer";
	}
	  
	//공지관리 페이지 보여주기
	@GetMapping(value = "/adminNotice")
	public String adminNotice() {
		
		return "admin/adminNotice";
	}
	
	//공지사항 등록 페이지 보여주기
	@GetMapping(value = "/adminNoticeReg")
	public String adminNoticeReg() {
		
		return "admin/adminNoticeReg";
	}
	
	//공지사항 수정 페이지 보여주기
	@GetMapping(value = "/adminNoticeModify")
	public String adminNoticeModify() {
		
		return "admin/adminNoticeModify";
	}
	
}
