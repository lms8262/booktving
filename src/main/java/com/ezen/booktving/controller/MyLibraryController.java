package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.booktving.dto.ChallengeNewDto;
import com.ezen.booktving.dto.FavoriteBookDtoList;
import com.ezen.booktving.dto.MyLibraryRentBookListDto;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.service.FavoriteBookService;
import com.ezen.booktving.service.MemberService;
import com.ezen.booktving.service.MyLibraryRentBookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyLibraryController {
	
	private final MyLibraryRentBookService myLibraryRentBookService;
	private final FavoriteBookService favoriteBookService;
	private final MemberService memberService;
	
	
	//나의서재 메인화면
	@GetMapping(value = "/myLibrary")
	public String myLibrary(Optional<Integer> page, Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		if(userDetails != null) {
			
			Member user = memberService.listAll(userDetails.getUsername());
			model.addAttribute("user", user);
			
			Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);

			//bookcase
			//isEmpty
			List<RentBook> rentBookList = myLibraryRentBookService.listAll(userDetails.getUsername());
			model.addAttribute("rentBookList", rentBookList);
			//not isEmpty
			Page<MyLibraryRentBookListDto> rentBooks = myLibraryRentBookService.getMyLibraryRentBookList(userDetails.getUsername(), pageable);
			model.addAttribute("rentBooks", rentBooks);
			
			//favoriteBook
			//isEmpty
			List<FavoriteBook> favoriteBookList = favoriteBookService.getFavoriteListAll(userDetails.getUsername());
			model.addAttribute("favoriteBookList", favoriteBookList);
			//not isEmpty
			Page<FavoriteBookDtoList> favoriteBooks = favoriteBookService.getFavoriteBookList(userDetails.getUsername(), pageable);
			model.addAttribute("favoriteBooks", favoriteBooks);
			
						
			return "myLibrary/myLibraryMain";
		} else {
			
			return "redirect:/login";
		}
	}
	
	//나의 서재 대여도서 리스트
	@GetMapping(value= {"/myLibrary/rentList", "/myLibrary/rentList/{page}"})
	public String myLibraryRentList(@PathVariable("page") Optional<Integer> page, Principal principal, Model model) {
		
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 8);
		
		//2. 서비스 호출
		Page<MyLibraryRentBookListDto> myLibraryRentBookListDtoList = myLibraryRentBookService.getMyLibraryRentBookList(principal.getName(), pageable);
		
		//3. 서비스에서 가져온 값들을 view단에 model을 이용해 전송
		model.addAttribute("rentBooks", myLibraryRentBookListDtoList);
		model.addAttribute("maxPage", 5);
		
		return "myLibrary/myLibraryRentBookList";
	}
	
	
	//나의 서재 대여도서 상세페이지 	
	@GetMapping(value = "/myLibrary/rentbookinfo")
	public String myLibraryRentBookInfo() {
			
		return "myLibrary/myLibraryRentBookInfo";
	}
	
	//나의챌린지 페이지
	@GetMapping(value = "/myLibrary/myChallenge")
	public String myChallenge(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		
		Member user = memberService.listAll(userDetails.getUsername());
		model.addAttribute("user", user);
		
		return "myLibrary/myChallenge";
	}
	
	//나의챌린지 생성 페이지
	@GetMapping(value = "/myLibrary/myChallenge/new")
	public String myChallengeNewPage(Model model, @AuthenticationPrincipal UserDetails userDetails, @Valid ChallengeNewDto challengeNewDto, BindingResult bindingResult ) {
		
		Member user = memberService.listAll(userDetails.getUsername());
		model.addAttribute("user", user);
		
		
		
		
		return "myLibrary/myChallengeNew";
	}
	
	//나의챌린지 생성하기
	@PostMapping(value = "/myLibrary/myChallenge/new")
	public String myChallengeNew() {
		return "myLibrary/myChallenge";
	}
}
