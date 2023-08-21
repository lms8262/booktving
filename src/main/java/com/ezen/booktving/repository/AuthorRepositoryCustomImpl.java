package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.dto.AuthorSearchDto;
import com.ezen.booktving.entity.Author;
import com.ezen.booktving.entity.QAuthor;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class AuthorRepositoryCustomImpl implements AuthorRepositoryCustom {
	
	private JPAQueryFactory queryFactory;
	
	public AuthorRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("authorNameKo", searchBy)) {
			//작가명으로 검색
			return QAuthor.author.authorNameKo.like("%" + searchQuery + "%");
		} else if (StringUtils.equals("id", searchBy)) {
			//작가아이디로 검색
			return QAuthor.author.id.like("%" + searchQuery + "%");
		} 
		return null;
	}
	
	//추천작가 관리 페이지
	@Override
	public Page<Author> getAdminAuthorPage(AuthorSearchDto authorSearchDto, Pageable pageable) {
		
		List<Author> content = queryFactory.selectFrom(QAuthor.author)
				                           .where(searchByLike(authorSearchDto.getSearchBy(), authorSearchDto.getSearchQuery()))
				                           .orderBy(QAuthor.author.id.desc())
				                           .offset(pageable.getOffset())
				                           .limit(pageable.getPageSize())
				                           .fetch();
		
		long total = queryFactory.select(Wildcard.count)
						.from(QAuthor.author)
						.where(searchByLike(authorSearchDto.getSearchBy(), authorSearchDto.getSearchQuery()))
						.fetchOne();
		
		return new PageImpl<>(content, pageable, total);
	}

}
