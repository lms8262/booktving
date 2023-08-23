package com.ezen.booktving.repository;

import java.time.LocalDateTime;
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

public class AdminBookRentListRepositoryCustomImpl implements AdminBookRentListRepositoryCustom{
	
	private JPAQueryFactory queryFactory;
	
	public AdminBookRentListRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	private BooleanExpression regDtsAfter(String searchDateType) {
		LocalDateTime dateTime = LocalDateTime.now();
		
		if(StringUtils.equals("all", searchDateType) || searchDateType == null) return null;
		else if(StringUtils.equals("1d", searchDateType))
			dateTime = dateTime.minusDays(1); // 현재로부터 1일전
		else if(StringUtils.equals("1w", searchDateType))
			dateTime = dateTime.minusWeeks(1); //현재로부터 1주일전
		else if(StringUtils.equals("1m", searchDateType))
			dateTime = dateTime.minusMonths(1); //현재로부터 1달전
		else if(StringUtils.equals("6m", searchDateType))
			dateTime = dateTime.minusMonths(6); //현재로부터 6개월전
		
		return QRentBook.rentBook.regTime.after(dateTime);
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
