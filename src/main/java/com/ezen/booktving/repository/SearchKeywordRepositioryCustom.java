package com.ezen.booktving.repository;

import java.util.List;

import com.ezen.booktving.dto.KeywordDto;

public interface SearchKeywordRepositioryCustom {
	
	List<KeywordDto> getSearchKeywordTop(Long limit);
	
	List<String> getSearchKeywordNameTop(Long limit);
}
