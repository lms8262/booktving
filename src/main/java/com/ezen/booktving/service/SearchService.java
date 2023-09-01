package com.ezen.booktving.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.SearchKeyword;
import com.ezen.booktving.repository.SearchKeywordRepositiory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SearchService {
	
	private final SearchKeywordRepositiory searchKeywordRepositiory;
	
	// 사용자가 검색시 검색 기록 저장
	public void addSearchKeyword(BookSearchDto bookSearchDto) {
		SearchKeyword searchKeyword = SearchKeyword.builder()
				.searchKeywordType(bookSearchDto.getSearchBy())
				.searchKeywordName(bookSearchDto.getSearchQuery())
				.build();
		
		searchKeywordRepositiory.save(searchKeyword);
	}
	
}
