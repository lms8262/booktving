 package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.ChallengeItem;

public interface ChallengeItemRepository extends JpaRepository<ChallengeItem, Long>{

	@Query("select c from ChallengeItem c where c.member.userId = :userId order by c.regTime desc")
	List<ChallengeItem> findChallengeItems(@Param("userId") String userId);
	
	@Query("select c from ChallengeItem c where c.member.userId = :userId")
    ChallengeItem findUserChallengeItem(@Param("userId") String userId);

	@Query("select c from ChallengeItem c where c.member.userId = :userId and c.isActive = Y")
	List<ChallengeItem> findActiveChallengeItems(@Param("userId") String userId);
	
	long countByIsActiveAndMember_UserId(YesNoStatus isActive, String userId);
}
