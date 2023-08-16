package com.ezen.booktving.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;
	private final BookImgService bookImgService;
	private final BookImgRepository bookImgRepository;
	
	public Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable) {
		
		Page<BookDto> bookPage = bookRepository.getBookDto(bookSearchDto, pageable);
		
		return null;
	}
	
}
