package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.Book;

public interface BookRepositoryCustom {
  
	Page<Book> getAdminBookPage(BookSearchDto bookSearchDto, Pageable pageable);
	
	Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable);
	
}


