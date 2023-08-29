package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.RecommendKeyword;

public interface RecommendKeywordRepository extends JpaRepository<RecommendKeyword, Long>, RecommendKeywordRepositoryCustom{
	RecommendKeyword findByRecommendKeywordName(String recommendKeywordName);
	
	List<RecommendKeyword> findTop15ByOrderByUpdateTimeDesc();
}
