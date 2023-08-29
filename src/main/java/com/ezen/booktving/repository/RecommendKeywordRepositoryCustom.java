package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.entity.RecommendKeyword;

public interface RecommendKeywordRepositoryCustom {
	
	Page<RecommendKeyword> getRecommendKeywordList(String searchKeywordName, Pageable pageable);
	
}
