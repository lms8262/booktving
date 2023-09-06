package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.dto.NoticeSearchDto;
import com.ezen.booktving.entity.Notice;
import com.ezen.booktving.entity.QNotice;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class NoticeRepositoryCustomImpl implements NoticeRepositoryCustom {

	private JPAQueryFactory queryFactory;
	
	public NoticeRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("title", searchBy)) {
			return QNotice.notice.title.like("%" + searchQuery + "%");
		} 
		return null;
	}
	
	//관리페이지 
	@Override
	public Page<Notice> getAdminNoticePage(NoticeSearchDto noticeSearchDto, Pageable pageable) {

		List<Notice> content = queryFactory.selectFrom(QNotice.notice)
										   .where(searchByLike(noticeSearchDto.getSearchBy(), noticeSearchDto.getSearchQuery()))
										   .orderBy(QNotice.notice.id.desc())
										   .offset(pageable.getOffset())
										   .limit(pageable.getPageSize())
										   .fetch();
		
		long total = queryFactory.select(Wildcard.count)
								 .from(QNotice.notice)
								 .where(searchByLike(noticeSearchDto.getSearchBy(), noticeSearchDto.getSearchQuery()))
								 .fetchOne();
		
		return new PageImpl<>(content, pageable, total);
	}

}
