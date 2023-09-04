package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ezen.booktving.entity.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long>{
	
	@Query("select c from Challenge c where c.member.userId = :userId order by c.regTime desc")
	List<Challenge> findChallenges(@Param("userId") String userId);
	
	@Query("select c from Challenge c where c.member.userId = :userId")
    Challenge findUserChallenge(@Param("userId") String userId);

}
