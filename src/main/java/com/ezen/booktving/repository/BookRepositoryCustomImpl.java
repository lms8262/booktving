package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class BookRepositoryCustomImpl implements BookRepositoryCustom{

	private JPAQueryFactory queryFactory;
	
	public BookRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	@Override
	public Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
