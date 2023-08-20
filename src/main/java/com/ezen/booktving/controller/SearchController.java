package com.ezen.booktving.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.json.simple.parser.ParseException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.dto.SearchBookDto;
import com.ezen.booktving.service.ApiService;
import com.ezen.booktving.service.SearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {
	
	private final ApiService apiService;
	private final SearchService searchService;
	
	@GetMapping(value = "/search/main")
	public String searchMain(Model model) {
		model.addAttribute("bookSearchDto", new BookSearchDto());
		return "search/searchMain";
	}
	
	@GetMapping(value = "/search/detail")
	public String searchDetail(BookSearchDto bookSearchDto, Model model) {
		
		Pageable pageble = PageRequest.of(0, 30);
		
		try {
			List<String> searchBookIsbnList = apiService.getSearchBookIsbnList(bookSearchDto, 1, 30);
			for(String isbn : searchBookIsbnList) {
				apiService.getBookInfoByAladinApi(isbn);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		Slice<SearchBookDto> searchBookList = searchService.getSearchBookList(null, bookSearchDto, pageble);
		Long searchCount = searchService.getSearchBookCount(bookSearchDto);
		
		model.addAttribute("bookSearchDto", bookSearchDto);
		model.addAttribute("searchBookList", searchBookList);
		model.addAttribute("searchCount", searchCount);
		
		return "search/searchDetail";
	}
	
	// 무한스크롤시 필요한 데이터 넘겨주기
	@GetMapping(value = "/search/detail/paging")
	@ResponseBody
	public ResponseEntity<Slice<SearchBookDto>> getSearchBookList(Long lastBookId, BookSearchDto bookSearchDto) {
		return null;
	}
}
