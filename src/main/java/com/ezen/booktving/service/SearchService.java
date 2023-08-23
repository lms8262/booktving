package com.ezen.booktving.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.dto.SearchBookDto;
import com.ezen.booktving.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SearchService {
	
	private final BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public Slice<SearchBookDto> getSearchBookList(Long lastBookId, BookSearchDto bookSearchDto, Pageable pageble) {
		return bookRepository.getSearchBookDto(lastBookId, bookSearchDto, pageble);
	}
	
	@Transactional(readOnly = true)
	public Long getSearchBookCount(BookSearchDto bookSearchDto) {
		return bookRepository.getSearchBookCount(bookSearchDto);
	}
	
}
