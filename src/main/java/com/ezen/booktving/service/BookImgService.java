package com.ezen.booktving.service;

import org.springframework.stereotype.Service;

import com.ezen.booktving.repository.BookImgRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BookImgService {
	
	private final BookImgRepository bookImgRepository;
}