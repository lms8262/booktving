package com.ezen.booktving.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.dto.KeywordDto;
import com.ezen.booktving.dto.SearchResultDto;
import com.ezen.booktving.service.ApiService;
import com.ezen.booktving.service.KeyWordService;
import com.ezen.booktving.service.SearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {
	
	private final ApiService apiService;
	private final SearchService searchService;
	private final KeyWordService keyWordService;
	
	@GetMapping(value = "/search/main")
	public String searchMain(Model model) {
		List<KeywordDto> recommendKeywordList = keyWordService.getRecommendKeywordLatest15();
		List<String> popularKeywordList = keyWordService.getSearchKeywordNameTop(10L);
		
		model.addAttribute("bookSearchDto", new BookSearchDto());
		model.addAttribute("recommendKeywordList", recommendKeywordList);
		model.addAttribute("popularKeywordList", popularKeywordList);
		
		return "search/searchMain";
	}
	
	// 검색 결과 페이지
	@GetMapping(value = "/search/detail")
	public String searchDetail(BookSearchDto bookSearchDto, Model model, RedirectAttributes redirectAttributes) {
		
		try {
			SearchResultDto firstSearchResult = apiService.getSearchResultByAladinApi(bookSearchDto, 0);
			searchService.addSearchKeyword(bookSearchDto);
			model.addAttribute("firstSearchResult", firstSearchResult);
			
		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addAttribute("errorMessage", "검색 중에 오류가 발생했습니다.");
			return "redirect:/search/main";
		}		
		
		return "search/searchDetail";
	}
	
	// 무한스크롤시 필요한 데이터 넘겨주기
	@PostMapping(value = "/search/detail/paging")
	@ResponseBody
	public ResponseEntity<SearchResultDto> getNextSearchBookList(@RequestBody Map<String, Object> data) {		
		
		Map<String, Object> bookSearchDtoMap = (HashMap) data.get("bookSearchDto");
		BookSearchDto bookSearchDto = new BookSearchDto((String) bookSearchDtoMap.get("searchBy"), (String) bookSearchDtoMap.get("searchQuery"));
		
		int currentPage = (int) data.get("currentPage");
		
		SearchResultDto nextSearchResult;
		try {
			nextSearchResult = apiService.getSearchResultByAladinApi(bookSearchDto, currentPage);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<SearchResultDto>(nextSearchResult, HttpStatus.OK);
	}
	
}
