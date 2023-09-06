package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.entity.NewBookTving;

public interface NewBookTvingRepositoryCustom {
	
	Page<NewBookTving> getNewBookTving(Pageable pageable);
	
}
