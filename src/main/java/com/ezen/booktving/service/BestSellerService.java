package com.ezen.booktving.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.BestSellerDto;
import com.ezen.booktving.repository.BestSellerRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BestSellerService {

	private final BestSellerRepository bestSellerRepository;
	
	
}
