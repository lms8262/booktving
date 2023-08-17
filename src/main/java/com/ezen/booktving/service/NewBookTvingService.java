package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.entity.NewBookTving;
import com.ezen.booktving.repository.NewBookTvingRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class NewBookTvingService {
	
	private final NewBookTvingRepository newBookTvingRepository;
	
	public Page<NewBookTving> getNewBookTving (Pageable pageable){
		
		Page<NewBookTving> newBookTvingPage = newBookTvingRepository.getNewBookTving(pageable);
		
		
		return newBookTvingPage;
	}
	
	public List<NewBookTving> getRandomNewBook(int count) {
		List<NewBookTving> allNewBooks = newBookTvingRepository.findAll();
		List<NewBookTving> randomNewBooks = new ArrayList<>();
		
		Random random = new Random();
		int totalNewBooks = allNewBooks.size();
		
		for(int i = 0; i < count; i++) {
			int randomIndex = random.nextInt(totalNewBooks);
			randomNewBooks.add(allNewBooks.get(randomIndex));
			
		}
		
		return randomNewBooks;
	}

}
