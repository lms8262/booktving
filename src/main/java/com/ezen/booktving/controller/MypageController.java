package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MypageController {
	
	@GetMapping(value = {"/mypage/rentlist", "/mypage/rentlist/{page}"})
	public String rentList(@PathVariable("page") Optional<Integer> page, Principal principal, Model model) {
		String userId = principal.getName();
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
		
		return "mypage/rentList";
	}
}
