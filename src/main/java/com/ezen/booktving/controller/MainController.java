package com.ezen.booktving.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.BestSeller;
import com.ezen.booktving.repository.BestSellerRepository;
import com.ezen.booktving.service.BestSellerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	

	private final BestSellerService bestSellerService;
	private final BestSellerRepository bestSellerRepository;
	
	@GetMapping(value = "/")
	public String main(BookSearchDto bookSearchDto, Optional<Integer> page, Model model) {
		
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0 , 7);
		Page<BestSeller> bestSellers = bestSellerService.getBestSeller(bookSearchDto, pageable);
		
		model.addAttribute("bestSellers", bestSellers);
		model.addAttribute("bookSearchDto", bookSearchDto);
		
		
		return "/main";
	}
	
}

