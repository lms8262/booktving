package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.dto.KeywordDto;
import com.ezen.booktving.entity.QRecommendKeyword;
import com.ezen.booktving.entity.RecommendKeyword;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class RecommendKeywordRepositoryCustomImpl implements RecommendKeywordRepositoryCustom {
	
	private JPAQueryFactory queryFactory;
	
	private RecommendKeywordRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	// 추천 키워드 관리 검색기능 조건에 따른 동적쿼리
	private BooleanExpression recommendKeywordNameLike(String searchKeywordName) {
		if(searchKeywordName == null || StringUtils.isEmptyOrWhitespace(searchKeywordName)) {
			return null;
		} else {
			return QRecommendKeyword.recommendKeyword.recommendKeywordName.like("%" + searchKeywordName + "%");
		}
	}
	
	@Override
	public Page<RecommendKeyword> getRecommendKeywordList(String searchKeywordName, Pageable pageable) {
		QRecommendKeyword recommendKeyword = QRecommendKeyword.recommendKeyword;
		
		List<RecommendKeyword> content = queryFactory
								   .selectFrom(recommendKeyword)
								   .orderBy(recommendKeyword.updateTime.desc())
								   .where(recommendKeywordNameLike(searchKeywordName))
								   .orderBy(recommendKeyword.updateTime.desc())
								   .offset(pageable.getOffset())
								   .limit(pageable.getPageSize())
								   .fetch();
		long total = queryFactory.select(Wildcard.count)
								 .from(recommendKeyword)
								 .where(recommendKeywordNameLike(searchKeywordName))
								 .fetchOne();
		
		return new PageImpl<>(content, pageable, total);
	}
	
}
