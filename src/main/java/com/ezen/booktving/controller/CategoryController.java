package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	
	@GetMapping(value = "/mainCategory")
	public String MainCategory() {
		
		return "category/mainCategory";
	}
}
