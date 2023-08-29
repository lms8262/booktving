package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.MemberSearchDto;
import com.ezen.booktving.entity.Member;

public interface MemberRepositoryCustom {
	Page<Member> getAdminMemberPage(MemberSearchDto memberSearchDto, Pageable pageable);
}
