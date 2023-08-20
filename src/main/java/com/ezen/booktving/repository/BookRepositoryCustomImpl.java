package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.dto.QSearchBookDto;
import com.ezen.booktving.dto.SearchBookDto;
import com.ezen.booktving.entity.QBook;
import com.ezen.booktving.entity.QBookImg;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
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
	
	// no-offset 처리를 위한 메소드
	private BooleanExpression ltBookId(Long bookId) {
		if(bookId == null) {
			return null;
		}
		
		return QBook.book.id.lt(bookId);
	}
	
	// 검색 조건에 따른 처리
	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("Title", searchBy)) {
			return QBook.book.bookName.like("%" + searchQuery + "%");
		}
		if(StringUtils.equals("Author", searchBy)) {
			return QBook.book.authorName.like("%" + searchQuery + "%");
		}
			
		if(StringUtils.equals("Publisher", searchBy)) {
			return QBook.book.publisher.like("%" + searchQuery + "%");
		}
		
		return null;
	}
	
	@Override
	public Slice<SearchBookDto> getSearchBookDto(Long lastBookId, BookSearchDto bookSearchDto, Pageable pageable) {
		QBook book = QBook.book;
		QBookImg bookImg = QBookImg.bookImg;
		
		List<SearchBookDto> content = queryFactory
				.select(
						new QSearchBookDto(
								book.id, 
								book.bookName, 
								book.isbn, 
								book.authorName, 
								bookImg.imgUrl)
						)
				.from(bookImg)
				.join(bookImg.book, book)
				.where(ltBookId(lastBookId))
				.where(searchByLike(bookSearchDto.getSearchBy(), bookSearchDto.getSearchQuery()))
				.where(bookImg.repYn.eq(YesNoStatus.Y))
				.orderBy(book.id.desc())
				.limit(pageable.getPageSize() + 1)
				.fetch();
		
		boolean hasNext = false;
		if(content.size() > pageable.getPageSize()) {
			content.remove(pageable.getPageSize());
			hasNext = true;
		}
		
		return new SliceImpl<SearchBookDto>(content, pageable, hasNext);
	}

	@Override
	public Long getSearchBookCount(BookSearchDto bookSearchDto) {
		QBook book = QBook.book;
		QBookImg bookImg = QBookImg.bookImg;
		
		Long count = queryFactory
				.select(Wildcard.count)
				.from(bookImg)
				.join(bookImg.book, book)
				.where(searchByLike(bookSearchDto.getSearchBy(), bookSearchDto.getSearchQuery()))
				.where(bookImg.repYn.eq(YesNoStatus.Y))
				.fetchOne();
		
		return count;
	}
	
}
