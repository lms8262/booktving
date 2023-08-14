package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

	//작가목록 페이지 보여주기
	@GetMapping(value = "/author/list")
	public String authorList() {
		
		return "author/authorList";
	}
	
	//작가 상세페이지 보여주기
		@GetMapping(value = "/author/Detail")
		public String authotDetail() {
			
			return "author/authorDetail";
		}
	
}
