package com.ezen.booktving.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.Book;

public interface BookRepositoryCustom {
	Page<Book> getAdminBookPage(BookSearchDto bookSearchDto, Pageable pageable);
	
	Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable);
	
}
//도서관리 페이지 보여주기 

