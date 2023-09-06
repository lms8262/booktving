package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.entity.QQuestion;
import com.ezen.booktving.entity.Question;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class AdminQuestionRepositoryCustomImpl implements AdminQuestionRepositoryCustom {

	private JPAQueryFactory queryFactory;

	private AdminQuestionRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public Page<Question> getQuestion(Pageable pageable) {
		List<Question> content = queryFactory.selectFrom(QQuestion.question)
											.orderBy(QQuestion.question.id.desc())
											.offset(pageable.getOffset())
											.limit(pageable.getPageSize())
											.fetch();

		long total = queryFactory.select(Wildcard.count).from(QQuestion.question)
														.fetchOne();

		return new PageImpl<>(content, pageable, total);
	}

}
