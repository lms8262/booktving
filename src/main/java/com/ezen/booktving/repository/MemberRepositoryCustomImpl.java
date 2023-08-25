package com.ezen.booktving.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.constant.Role;
import com.ezen.booktving.dto.MemberSearchDto;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.QMember;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {
	private JPAQueryFactory queryFactory;

	public MemberRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public Page<Member> getAdminMemberPage(MemberSearchDto memberSearchDto, Pageable pageable) {
		JPQLQuery<Member> query = queryFactory.selectFrom(QMember.member)
				.where(regDtsAfter(memberSearchDto.getSearchDateType()), roleEq(memberSearchDto.getRole()),
						searchByLike(memberSearchDto.getSearchBy(), memberSearchDto.getSearchQuery()))
				.orderBy(QMember.member.id.desc());

		List<Member> content = query.offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();

		long total = query.fetchCount();

		return new PageImpl<>(content, pageable, total);
	}

	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if (StringUtils.equals("memberName", searchBy)) {
			return QMember.member.memberName.like("%" + searchQuery + "%");
		}
		return null;
	}

	private BooleanExpression regDtsAfter(String searchDateType) {
		LocalDateTime dateTime = LocalDateTime.now();

		if (StringUtils.equals("all", searchDateType) || searchDateType == null) {
			return null;
		} else if (StringUtils.equals("1d", searchDateType))
			dateTime = dateTime.minusDays(1);
		else if (StringUtils.equals("1w", searchDateType))
			dateTime = dateTime.minusWeeks(1);
		else if (StringUtils.equals("1m", searchDateType))
			dateTime = dateTime.minusMonths(1);
		else if (StringUtils.equals("6m", searchDateType))
			dateTime = dateTime.minusMonths(6);
		return QMember.member.regTime.after(dateTime);
	}

	private BooleanExpression roleEq(Role role) {
		return role == null ? null : QMember.member.role.eq(role);
	}

}
