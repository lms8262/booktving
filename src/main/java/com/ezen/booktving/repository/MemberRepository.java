package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ezen.booktving.constant.Role;
import com.ezen.booktving.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
	Member findByUserId(String userId);

	Member findByMemberNameAndEmail(String memberName, String email);

	Member findByEmail(String email);

	Member findByTel(String tel);
	
	Member findByUserIdAndEmail(String userId, String Email);

	Member findByRole(Role role);

	Member findByMemberName(String name);
	
	@Query("select m from Member m where m.userId = :userId")
	Member findByLogInUserId(@Param("userId") String userId);

}