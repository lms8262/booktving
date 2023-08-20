package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.dto.SearchBookDto;

public interface BookRepositoryCustom {
	
	Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable);
	
	// 검색시 화면에 보여줄 데이터
	Slice<SearchBookDto> getSearchBookDto(Long lastBookId, BookSearchDto bookSearchDto, Pageable pageable);
	
	// 검색시 데이터 총 갯수
	Long getSearchBookCount(BookSearchDto bookSearchDto);
}
