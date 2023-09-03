package com.ezen.booktving.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.booktving.dto.CategoryResultDto;
import com.ezen.booktving.service.ApiService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CategoryController {
	
	private final ApiService apiService;
	
	//카테고리 페이지 보여주기
	@GetMapping(value = "/category")
	public String mainCategory() {
		
		return "category/category";
	}
	
	// 카테고리별 책 리스트 보여주기
	@GetMapping(value = "/category/detail")
	public String categoryDetail(int categoryId, String categoryName, Model model, RedirectAttributes redirectAttributes) {
		
		try {
			CategoryResultDto firstCategoryResult = apiService.getCategoryResultByAladinApi(categoryId, 0);
			model.addAttribute("firstCategoryResult", firstCategoryResult);
			
		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addAttribute("errorMessage", categoryName + " 도서 로딩 중에 오류가 발생했습니다.");
			return "redirect:/category";
		}
		
		model.addAttribute("categoryName", categoryName);
		return "category/categoryDetail";
	}
	
	@PostMapping(value = "/category/detail/paging")
	@ResponseBody
	public ResponseEntity<CategoryResultDto> getNextCategoryBookList(@RequestBody Map<String, Object> data) {
		
		int categoryId = (int) data.get("categoryId");
		int currentPage = (int) data.get("currentPage");
		
		CategoryResultDto nextCategoryResult;
		try {
			nextCategoryResult = apiService.getCategoryResultByAladinApi(categoryId, currentPage);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CategoryResultDto>(nextCategoryResult, HttpStatus.OK);
	}
	
}
