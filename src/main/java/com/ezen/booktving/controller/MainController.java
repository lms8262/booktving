package com.ezen.booktving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.booktving.entity.BestSeller;
import com.ezen.booktving.entity.NewBookTving;
import com.ezen.booktving.service.BestSellerService;
import com.ezen.booktving.service.NewBookTvingService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	//베스트셀러 관련 의존성 주입
	private final BestSellerService bestSellerService;
	
	//신간리스트 관련 의존성 주입
	private final NewBookTvingService newBookTvingService;
	
	@GetMapping(value = "/")
	public String main(Optional<Integer> page, Model model) {
		
		//서점 베스트셀러
		Pageable pageable1 = PageRequest.of(page.isPresent() ? page.get() : 0 , 10);
		Page<BestSeller> bestSellers = bestSellerService.getBestSeller(pageable1);
		model.addAttribute("bestSellers", bestSellers);
		
		//NEW 북티빙
		//Pageable pageable2 = PageRequest.of(page.isPresent() ? page.get() : 0 , 4);
		//Page<NewBookTving> newBookTvings = newBookTvingService.getNewBookTving(pageable2);
		//model.addAttribute("newBooks", newBookTvings);

		List<NewBookTving> randomNewBooks = newBookTvingService.getRandomNewBook(4);
		model.addAttribute("randomNewBooks", randomNewBooks);
		
		return "/main";
	}
	
}
