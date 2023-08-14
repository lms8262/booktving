package com.ezen.booktving.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.BestSellerDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.repository.BestSellerRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BestSellerService {

	private final BestSellerRepository bestSellerRepository;
	
	public Page<BestSellerDto> getBestSellerDto(BookSearchDto bookSearchDto, Pageable pageable){
		
		Page<BestSellerDto> bestSellerPage = bestSellerRepository.getBestSellerDto(bookSearchDto, pageable);
		
		return null;
	}
	
	
}
