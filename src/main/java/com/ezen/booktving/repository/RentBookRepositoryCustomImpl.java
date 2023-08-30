package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.QRentBook;
import com.ezen.booktving.entity.RentBook;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class RentBookRepositoryCustomImpl implements RentBookRepositoryCustom{
	
	private JPAQueryFactory queryFactory;
	
	public RentBookRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("bookId", searchBy)) {
			return QRentBook.rentBook.book.id.like("%" + searchQuery + "%");
		}else if (StringUtils.equals("bookName", searchBy)) {
			return QRentBook.rentBook.book.bookName.like("%" + searchQuery + "%");
		}else if (StringUtils.equals("userId", searchBy)) {
			return QRentBook.rentBook.member.userId.like("%" + searchQuery + "%");
		}
		
		return null; //쿼리문 실행 x
	}

	@Override
	public Page<RentBook> getAdminRentBookPage(BookSearchDto bookSearchDto, Pageable pageable) {
		
		List<RentBook> content = queryFactory
				.selectFrom(QRentBook.rentBook)
				.where(searchByLike(bookSearchDto.getSearchBy(), bookSearchDto.getSearchQuery()))
				.orderBy(QRentBook.rentBook.id.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();

		long total = queryFactory.select(Wildcard.count).from(QRentBook.rentBook)
			.where(searchByLike(bookSearchDto.getSearchBy(), bookSearchDto.getSearchQuery()))
			.fetchOne();
		
		return new PageImpl<>(content, pageable, total);
	}
	
	
}
