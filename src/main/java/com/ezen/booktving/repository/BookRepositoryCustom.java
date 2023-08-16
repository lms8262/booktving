package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;

public interface BookRepositoryCustom {
	
	Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable);
}
