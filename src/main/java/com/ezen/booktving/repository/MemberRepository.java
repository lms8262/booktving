package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.constant.Role;
import com.ezen.booktving.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
	Member findByUserId(String userId);

	Member findByMemberNameAndEmail(String memberName, String email);

	Member findByEmail(String email);

	Member findByTel(String tel);

	Member findByUserIdAndEmail(String userId, String Email);

	/*
	 * @Select("SELECT SELECT MID FROM member WHERE MID= #{mid}") String
	 * checkIdUser(@Param("mid")String mid);
	 */
	Member findByProviderAndProviderId(String provider, String providerId);

	Member findByRole(Role role);

	Member findByMemberName(String name);

}