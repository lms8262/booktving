package com.ezen.booktving.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.auth.PrincipalDetails;
import com.ezen.booktving.dto.BookDto;

import com.ezen.booktving.dto.BookReviewDto;
import com.ezen.booktving.service.ApiService;
import com.ezen.booktving.service.BookService;
import com.ezen.booktving.service.CommutationService;
import com.ezen.booktving.service.FavoriteBookService;
import com.ezen.booktving.service.RentBookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	private final FavoriteBookService favoriteBookService;
	private final ApiService apiService;
	private final CommutationService commutationService;
	private final RentBookService rentBookService;
	
	// 도서상세 페이지
	@GetMapping(value = "/book/bookDetail/{isbn}")
	public String bookDetail(Model model, @PathVariable("isbn") String isbn) {
		
		// db에 책 상세정보 있는지 확인 후 없으면 api 호출해서 저장
		try {
			apiService.saveBookInfo(isbn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BookDto bookDto = bookService.getBookDetail(isbn);
		model.addAttribute("books", bookDto);
		return "book/bookDetail";
	}

	// 도서 찜하기
	@PostMapping(value = "/book/bookDetail/likeBook")
	public @ResponseBody ResponseEntity like(@RequestBody HashMap<String, String> map, Authentication authentication) {
		if(authentication == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		String isbn = map.get("isbn");
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();

		Long id = favoriteBookService.like(userId, isbn);

		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	// 리뷰 등록
	@PostMapping(value = "/book/bookDetail/review/{isbn}")
	public String reviewCreate(Authentication authentication, BookReviewDto bookReviewDto, @PathVariable("isbn") String isbn) {
		if(authentication == null) {
			return "redirect:/login";
		}
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		bookService.saveReview(bookReviewDto, userId, isbn);
		return "redirect:/book/bookDetail/" + isbn;
	}
	
	// 도서 대여요청
	@PostMapping(value = "/book/bookDetail/rent/{isbn}")
	@ResponseBody
	public ResponseEntity rentBook(@PathVariable("isbn") String isbn, Authentication authentication) {
		if(authentication == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		
		if(!commutationService.isExistsMemberCommutation(userId)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		Long result = rentBookService.saveRentBook(userId, isbn);
		
		return new ResponseEntity<Long>(result, HttpStatus.OK);
	}
	
}