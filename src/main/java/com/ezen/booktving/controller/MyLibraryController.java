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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezen.booktving.dto.FavoriteAuthorListDto;
import com.ezen.booktving.dto.MyLibraryRentBookListDto;
import com.ezen.booktving.entity.FavoriteAuthor;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.service.AuthorService;
import com.ezen.booktving.service.MyLibraryRentBookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyLibraryController {
	
	private final MyLibraryRentBookService myLibraryRentBookService;
	private final AuthorService authorService;
	
	
	//나의서재 메인화면
	@GetMapping(value = "/mylibrary")
	public String myLibrary(Optional<Integer> page, Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		if(userDetails != null) {
			
			Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);

			//bookcase
			//isEmpty
			List<RentBook> rentBookList = myLibraryRentBookService.listAll(userDetails.getUsername()) ;
			model.addAttribute("rentBookList", rentBookList);
			//not isEmpty
			Page<MyLibraryRentBookListDto> rentBooks = myLibraryRentBookService.getMyLibraryRentBookList(userDetails.getUsername(), pageable);
			model.addAttribute("rentBooks", rentBooks);
			
			//favorite
			//isEmpty
			//List<FavoriteBook> favoriteBookList = ;
			//not isEmpty
			
			//author
			//isEmpty
			List<FavoriteAuthor> favoriteAuthorList = authorService.listAll(userDetails.getUsername());
			model.addAttribute("favoriteAuthorList", favoriteAuthorList);
			//not isEmpty
			Page<FavoriteAuthorListDto> favoriteAuthors = authorService.getMyLibraryAuthorList(userDetails.getUsername(), pageable);
			model.addAttribute("favoriteAuthors", favoriteAuthors);
			
			
			return "mylibrary/mylibraryMain";
		} else {
			
			return "redirect:/login";
		}
		
		
	}
	
	//나의 서재 대여도서 리스트
	@GetMapping(value= {"/mylibrary/rentList", "/mylibrary/rentList/{page}"})
	public String myLibraryRentList(@PathVariable("page") Optional<Integer> page, Principal principal, Model model) {
		
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 8);
		
		//2. 서비스 호출
		Page<MyLibraryRentBookListDto> myLibraryRentBookListDtoList = myLibraryRentBookService.getMyLibraryRentBookList(principal.getName(), pageable);
		
		//3. 서비스에서 가져온 값들을 view단에 model을 이용해 전송
		model.addAttribute("rentBooks", myLibraryRentBookListDtoList);
		model.addAttribute("maxPage", 5);
		
		return "mylibrary/myLibraryList";
	}
	
	
	//나의 서재 대여도서 상세페이지 	
	@GetMapping(value = "/mylibrary/rentbookinfo")
	public String myLibraryRentBookInfo() {
			
		return "mylibrary/myLibraryRentBookInfo";
	}
}
