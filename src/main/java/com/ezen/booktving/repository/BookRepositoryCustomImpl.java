package com.ezen.booktving.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.QBook;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class BookRepositoryCustomImpl implements BookRepositoryCustom{
	
	private JPAQueryFactory queryFactory;
	
	public BookRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	private BooleanExpression regDtsAfter(String searchDateType) {
		LocalDateTime dateTime = LocalDateTime.now(); //현재날짜, 시간
		
		if(StringUtils.equals("all", searchDateType) || searchDateType == null) return null;
		else if(StringUtils.equals("1d", searchDateType))
				dateTime = dateTime.minusDays(1); // 현재로부터 1일전
		else if(StringUtils.equals("1w", searchDateType))
				dateTime = dateTime.minusWeeks(1); //현재로부터 1주일전
		else if(StringUtils.equals("1m", searchDateType))
				dateTime = dateTime.minusMonths(1); //현재로부터 1달전
		else if(StringUtils.equals("6m", searchDateType))
				dateTime = dateTime.minusMonths(6); //현재로부터 6개월전
		
		return QBook.book.regTime.after(dateTime); //Q객체 리턴
	}
	
	
	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("bookName", searchBy)) {
			//searchBy가 bookName 이라면
			return QBook.book.bookName.like("%"+ searchQuery + "%");
		} else if (StringUtils.equals("isbn", searchBy)) {
			return QBook.book.isbn.like("%"+ searchQuery + "%");
		} else if (StringUtils.equals("author", searchBy)) {
			return QBook.book.author.like("%" + searchQuery + "%");
		} else if (StringUtils.equals("publisher", searchBy)) {
			return QBook.book.publisher.like("%" + searchQuery + "%");
		} else if (StringUtils.equals("id", searchBy)) {
			return QBook.book.id.like("%" + searchQuery + "%");
		}
		
		return null; // 쿼리문 실행 x
	}

	@Override
	public Page<Book> getAdminBookPage(BookSearchDto bookSearchDto, Pageable pageable) {
		
		List<Book> content = queryFactory
							.selectFrom(QBook.book)
							.where(searchByLike(bookSearchDto.getSearchBy(), bookSearchDto.getSearchQuery()))
							.orderBy(QBook.book.id.desc())
							.offset(pageable.getOffset())
							.limit(pageable.getPageSize())
							.fetch();
		
		long total = queryFactory.select(Wildcard.count).from(QBook.book)
				.where(searchByLike(bookSearchDto.getSearchBy(), bookSearchDto.getSearchQuery()))
				.fetchOne();
		
		
		return new PageImpl<>(content, pageable, total);
	}
	
	//검색어가 빈 문자열 일때 
	private BooleanExpression bookNameLike(String searchQuery) {
		return StringUtils.isEmpty(searchQuery) ?
				null : QBook.book.bookName.like("%" + searchQuery + "%");
	}
	
	@Override
	public Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
