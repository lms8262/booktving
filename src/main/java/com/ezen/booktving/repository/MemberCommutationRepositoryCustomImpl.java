package com.ezen.booktving.repository;

import com.ezen.booktving.dto.MemberCommutationDto;
import com.ezen.booktving.dto.QMemberCommutationDto;
import com.ezen.booktving.entity.QMember;
import com.ezen.booktving.entity.QMemberCommutation;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class MemberCommutationRepositoryCustomImpl implements MemberCommutationRepositoryCustom {
	private JPAQueryFactory queryFactory;
	
	public MemberCommutationRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public MemberCommutationDto getMemberCommutationInfo(String userId) {
		QMemberCommutation memberCommutation = QMemberCommutation.memberCommutation;
		QMember member = QMember.member;
		
		MemberCommutationDto content = queryFactory
				.select(
						new QMemberCommutationDto(
								memberCommutation.regTime, 
								memberCommutation.endDate
								)
						)
				.from(memberCommutation)
				.join(memberCommutation.member, member)
				.where(member.userId.eq(userId))
				.fetchOne();
		
		return content;
	}
	
}
