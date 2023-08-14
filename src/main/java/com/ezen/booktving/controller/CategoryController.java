package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	
	//카테고리 메인 페이지 보여주기
	@GetMapping(value = "/mainCategory")
	public String MainCategory() {
		
		return "category/mainCategory";
	}
	
	
	//서브 카테고리 페이지 보여주기
	@GetMapping(value= "/subCategory")
	public String SubCategory() {
		
		return "category/subCategory";
	}
}
