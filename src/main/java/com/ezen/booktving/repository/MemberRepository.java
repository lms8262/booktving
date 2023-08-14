package com.ezen.booktving.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByUserId(String userId);
}
