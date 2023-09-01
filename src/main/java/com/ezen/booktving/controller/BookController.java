package com.ezen.booktving.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.dto.BookDto;

import com.ezen.booktving.dto.BookReviewDto;
import com.ezen.booktving.dto.FavoriteBookDto;
import com.ezen.booktving.entity.Book;
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
		List<BookReviewDto> bookReviewDtoList = new ArrayList<BookReviewDto>();
		model.addAttribute("reviews", bookReviewDtoList);
		model.addAttribute("books", bookDto);
		return "book/bookDetail";
	}

	// 도서 찜하기
	@PostMapping(value = "/book/bookDetail/likeBook")
	public @ResponseBody ResponseEntity like(@RequestBody HashMap<String, String> map, Principal principal) {
		String isbn = map.get("isbn");
		String userId = principal.getName();

		Long id = favoriteBookService.like(userId, isbn);

		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	// 찜 목록
	@GetMapping(value = "/book/myFavorite/{userId}")
	public String myFavorite(Model model, Principal principal) {
		String userId = principal.getName();

		// 사용자의 찜한 도서 목록 가져오기
		List<FavoriteBookDto> favoriteBookDtos = favoriteBookService.getFavoriteBooksByMember(userId);

		model.addAttribute("favoriteBooks", favoriteBookDtos);

		return "book/myFavorite";
	}

	// 찜 삭제
	@DeleteMapping("/book/myFavorite/remove/{id}")
	public @ResponseBody ResponseEntity removeFavoriteBook(@PathVariable("id") Long id, Principal principal) {
		System.out.println("id: " + id);
		favoriteBookService.removeFavoriteBook(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	// 리뷰
	@PostMapping(value = "/book/bookDetail/{isbn}/review")
	public String reviewCreate(BookReviewDto bookReviewDto, @PathVariable("isbn") String isbn) {
		Book book = bookService.getBookByIsbn(isbn); // 해당 Book 엔티티 가져오기
		bookReviewDto.setBook(book); // BookReviewDto에 Book 엔티티 설정
		bookService.saveReview(bookReviewDto);
		return "redirect:/book/bookDetail/{isbn}";
	}
	
	// 도서 대여요청
	@PostMapping(value = "/book/bookDetail/rent/{isbn}")
	@ResponseBody
	public ResponseEntity rentBook(@PathVariable("isbn") String isbn, Principal principal) {
		String userId = principal.getName();
		
		if(!commutationService.isExistsMemberCommutation(userId)) {
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		
		Long result = rentBookService.saveRentBook(userId, isbn);
		
		return new ResponseEntity<Long>(result, HttpStatus.OK);
	}
	
}