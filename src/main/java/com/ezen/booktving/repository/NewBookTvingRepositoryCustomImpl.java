package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.entity.NewBookTving;
import com.ezen.booktving.entity.QNewBookTving;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class NewBookTvingRepositoryCustomImpl implements NewBookTvingRepositoryCustom {

	private JPAQueryFactory queryFactory;
	
	private NewBookTvingRepositoryCustomImpl (EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	@Override
	public Page<NewBookTving> getNewBookTving(Pageable pageable) {
		
		List<NewBookTving> content =queryFactory.selectFrom(QNewBookTving.newBookTving)
											.orderBy(QNewBookTving.newBookTving.id.asc())
											.offset(pageable.getOffset())
											.limit(pageable.getPageSize())
											.fetch();

		long total = queryFactory.select(Wildcard.count)
							.from(QNewBookTving.newBookTving)
							.fetchOne();

		return new PageImpl<>(content, pageable, total);
	}
	
}
