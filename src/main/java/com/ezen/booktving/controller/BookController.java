package com.ezen.booktving.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookReviewDto;
import com.ezen.booktving.service.ApiService;
import com.ezen.booktving.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	private final ApiService apiService;
	
	//도서상세 페이지
	@GetMapping(value = "/book/bookDetail/{isbn}") //개발 후 경로 변경 {isbn}
	public String bookDetail(Model model, @PathVariable("isbn") String isbn) {
		BookDto bookDto = bookService.getBookDetail(isbn);
		//List<BookReviewDto> bookReviewDtoList = bookService.getBookDetail(isbn);
		//model.addAttribute("reviews", bookReviewDtoList);
		model.addAttribute("books", bookDto);
		return "/book/bookDetail";
	}
	
}
