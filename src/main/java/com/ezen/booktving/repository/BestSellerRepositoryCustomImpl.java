package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.BestSellerDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class BestSellerRepositoryCustomImpl implements BestSellerRepositoryCustom {

	private JPAQueryFactory queryFactory;

	@Override
	public Page<BestSellerDto> getBestSellerDto(BookSearchDto bookSearchDto, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
