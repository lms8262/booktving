package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	//도서상세 페이지
	@GetMapping(value = "/bookDetail/") //개발 후 경로 변경 {bookId}
	public String bookDetail() {
		
		return "book/bookDetail";
	}
}
