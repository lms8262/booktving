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
	@GetMapping(value = "/adminAsk")
	public String adminAsk() {
		
		return "admin/adminAsk";
	}
	
	//공지관리 페이지 보여주기
	@GetMapping(value = "/adminNotice")
	public String adminNotice() {
		
		return "admin/adminNotice";
	}
	
}
