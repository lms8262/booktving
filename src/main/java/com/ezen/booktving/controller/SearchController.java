package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.booktving.dto.BookSearchDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {
	
	@GetMapping(value = "/search/main")
	public String searchMain(Model model) {
		
		return "search/searchMain";
	}
	
	@GetMapping(value = "/search/detail")
	public String searchDetail(BookSearchDto bookSearchDto, Model model) {
		
		model.addAttribute("bookSearchDto", bookSearchDto);
		return "search/searchDetail";
	}
}
