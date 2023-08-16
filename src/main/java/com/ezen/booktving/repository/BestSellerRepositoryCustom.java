package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.BestSeller;

public interface BestSellerRepositoryCustom {

	Page<BestSeller> getBestSeller(Pageable pageable);
}
