package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.entity.BestSeller;
import com.ezen.booktving.entity.QBestSeller;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class BestSellerRepositoryCustomImpl implements BestSellerRepositoryCustom {

	private JPAQueryFactory queryFactory;
	
	private BestSellerRepositoryCustomImpl (EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	/*
	
	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("title", searchBy)) {
			return QBestSeller.bestSeller.title.like("%" + searchQuery + "%");
		} else if (StringUtils.equals("isbn", searchBy)) {
			return QBestSeller.bestSeller.isbn.like("%" + searchQuery + "%");
		}
		return null;
	}
	
	*/

	//메인페이지 -> 서점 베스트셀러 List
	@Override
	public Page<BestSeller> getBestSeller(Pageable pageable) {

		
		List<BestSeller> content = queryFactory.selectFrom(QBestSeller.bestSeller)
											   .orderBy(QBestSeller.bestSeller.id.asc())
											   .offset(pageable.getOffset())
											   .limit(pageable.getPageSize())
											   .fetch();
		long total = queryFactory.select(Wildcard.count)
							.from(QBestSeller.bestSeller)
							.fetchOne();				   
		
		return new PageImpl<>(content, pageable, total);
	}
	
}
