package com.ezen.booktving.repository;

import java.util.Set;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.dto.SearchBookDto;
import com.ezen.booktving.entity.Book;

public interface BookRepositoryCustom {
  
	Page<Book> getAdminBookPage(BookSearchDto bookSearchDto, Pageable pageable);
	
	Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable);
	
	// 검색시 화면에 보여줄 데이터
	Slice<SearchBookDto> getSearchBookDto(Long lastBookId, BookSearchDto bookSearchDto, Pageable pageable);
	
	// 검색시 데이터 총 갯수
	Long getSearchBookCount(BookSearchDto bookSearchDto);
	
	Set<String> getAllBookIsbn();

}


