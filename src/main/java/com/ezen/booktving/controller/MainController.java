package com.ezen.booktving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.ezen.booktving.dto.BestSellerDto;
import com.ezen.booktving.service.BestSellerService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	

	private final BestSellerService bestSellerService;
	
	@GetMapping(value = "/")
	public String main(Optional<Integer> page, Model model) {
		
		/* List<BestSellerDto> bestSeller = bestSellerService.getBestSellerList(); */
		
		
		return "main";
	}
	
}

