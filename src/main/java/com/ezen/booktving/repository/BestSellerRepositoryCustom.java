package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.BestSellerDto;
import com.ezen.booktving.dto.BookSearchDto;

public interface BestSellerRepositoryCustom {

	Page<BestSellerDto> getBestSellerDto(BookSearchDto bookSearchDto, Pageable pageable);
}
