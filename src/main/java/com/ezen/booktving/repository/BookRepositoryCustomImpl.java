package com.ezen.booktving.repository;

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
	
	@Override
	public Page<BookDto> getBookDto(BookSearchDto bookSearchDto, Pageable pageable) {
		return getBookDto(bookSearchDto, pageable);
	}
	
}
