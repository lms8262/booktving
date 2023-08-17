package com.ezen.booktving.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.service.ApiService;
import com.ezen.booktving.service.BookService;

@Controller
public class BookController {

	private BookService bookService;
	private ApiService apiService;
	
	//도서상세 페이지
	@GetMapping(value = "/book/bookDetail/{isbn}") //개발 후 경로 변경 {isbn}
	public String bookDetail(Model model, @PathVariable("isbn") String isbn) {
		BookDto bookDto = bookService.getBookDetail(isbn);
		model.addAttribute("book", bookDto);
		return "/book/bookDetail";
	}
	
}
