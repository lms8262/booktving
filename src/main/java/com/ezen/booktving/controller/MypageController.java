package com.ezen.booktving.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezen.booktving.auth.PrincipalDetails;
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
	
	// 나의정보 대여내역
	@GetMapping(value = {"/mypage/rentlist", "/mypage/rentlist/{page}"})
	public String rentList(@PathVariable("page") Optional<Integer> page, Authentication authentication, Model model) {
		if(authentication == null) {
			return "redirect:/login";
		}
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
		
		//2. 서비스 호출
		Page<BookRentHistDto> bookrentHistDtoList = mypageRentBookService.getBookRentHistList(userId, pageable);		
		
		//3. 서비스에서 가져온 값들을 view단에 model을 이용해 전송
		model.addAttribute("rentBooks", bookrentHistDtoList);
		model.addAttribute("maxPage", 5);
		
		return "mypage/rentList";
	}
	
	// 나의정보 이용권 관리 
	@GetMapping(value = "/mypage/commutation")
	public String myCommutation(Authentication authentication, Model model) {
		if(authentication == null) {
			return "redirect:/login";
		}
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		
		MemberCommutationDto memberCommutationInfo = commutationService.getMemberCommutationInfo(userId);
		model.addAttribute("memberCommutationInfo", memberCommutationInfo);
		
		return "mypage/myCommutation";
	}
	
}
