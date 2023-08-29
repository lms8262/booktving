package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezen.booktving.dto.BookRentHistDto;
import com.ezen.booktving.dto.MemberCommutationDto;
import com.ezen.booktving.service.CommutationService;
import com.ezen.booktving.service.MypageRentBookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MypageController {
	
	private final MypageRentBookService mypageRentBookService;
	private final CommutationService commutationService;
	
	@GetMapping(value = {"/mypage/rentlist", "/mypage/rentlist/{page}"})
	public String rentList(@PathVariable("page") Optional<Integer> page, Principal principal, Model model) {
		if(principal == null) {
			return "redirect:/login";
		}
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
		
		//2. 서비스 호출
		Page<BookRentHistDto> bookrentHistDtoList = mypageRentBookService.getBookRentHistList(principal.getName(), pageable);		
		
		//3. 서비스에서 가져온 값들을 view단에 model을 이용해 전송
		model.addAttribute("rentBooks", bookrentHistDtoList);
		model.addAttribute("maxPage", 5);
		
		return "mypage/rentList";
	}
	
	@GetMapping(value = "/mypage/commutation")
	public String myCommutation(Principal principal, Model model) {
		if(principal == null) {
			return "redirect:/login";
		}
		
		MemberCommutationDto memberCommutationInfo = commutationService.getMemberCommutationInfo(principal.getName());
		model.addAttribute("memberCommutationInfo", memberCommutationInfo);
		
		return "mypage/myCommutation";
	}
	
}
