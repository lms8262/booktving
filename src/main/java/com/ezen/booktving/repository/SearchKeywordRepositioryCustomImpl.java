package com.ezen.booktving.repository;

import java.util.List;

import com.ezen.booktving.dto.KeywordDto;
import com.ezen.booktving.dto.QKeywordDto;
import com.ezen.booktving.entity.QSearchKeyword;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class SearchKeywordRepositioryCustomImpl implements SearchKeywordRepositioryCustom {

	private JPAQueryFactory queryFactory;
	
	private SearchKeywordRepositioryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	@Override
	public List<KeywordDto> getSearchKeywordTop(Long limit) {
		QSearchKeyword searchKeyword = QSearchKeyword.searchKeyword;
		
		List<KeywordDto> searchKeywordList = queryFactory
				.select(
						new QKeywordDto(
							searchKeyword.searchKeywordType, 
							searchKeyword.searchKeywordName
							)
						)
				.from(searchKeyword)
				.groupBy(searchKeyword.searchKeywordType, searchKeyword.searchKeywordName)
				.orderBy(searchKeyword.searchKeywordName.count().desc())
				.limit(limit)
				.fetch();
											
		return searchKeywordList;
	}

	@Override
	public List<String> getSearchKeywordNameTop(Long limit) {
		QSearchKeyword searchKeyword = QSearchKeyword.searchKeyword;
		
		List<String> popularKeywordNameList = queryFactory
				.select(searchKeyword.searchKeywordName)
				.from(searchKeyword)
				.where(searchKeyword.searchKeywordType.ne("Publisher"))
				.groupBy(searchKeyword.searchKeywordName)
				.orderBy(searchKeyword.searchKeywordName.count().desc())
				.limit(limit)
				.fetch();
		
		return popularKeywordNameList;
	}
	
}
