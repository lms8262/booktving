package com.ezen.booktving.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.repository.BestSellerRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MainService {

	private final BestSellerRepository bestSellerRepository;
	
	

}

