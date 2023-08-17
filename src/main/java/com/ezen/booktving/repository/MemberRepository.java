package com.ezen.booktving.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByUserId(String userId);
	
	Member findByMemberNameAndEmail(String memberName, String email);

	Member findByEmail(String email);

	Member findByTel(String tel);
	/*
	 * @Select("SELECT SELECT MID FROM member WHERE MID= #{mid}") String
	 * checkIdUser(@Param("mid")String mid);
	 */
	
}
