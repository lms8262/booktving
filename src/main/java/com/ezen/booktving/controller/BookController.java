package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookReviewDto;
import com.ezen.booktving.dto.FavoriteBookDto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.service.ApiService;
import com.ezen.booktving.service.BookService;
import com.ezen.booktving.service.FavoriteBookService;
import com.ezen.booktving.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	private final ApiService apiService;
	private final FavoriteBookService favoriteBookService;
	private final MemberService memberService;
	private final MemberRepository memberRepository;

	// 도서상세 페이지
	@GetMapping(value = "/book/bookDetail/{isbn}") // 개발 후 경로 변경 {isbn}
	public String bookDetail(Model model, @PathVariable("isbn") String isbn) {
		BookDto bookDto = bookService.getBookDetail(isbn);
		List<BookReviewDto> bookReviewDtoList = new ArrayList<BookReviewDto>();
		model.addAttribute("reviews", bookReviewDtoList);
		model.addAttribute("books", bookDto);
		return "/book/bookDetail";
	}

	// 도서 찜하기
	@PostMapping(value = "/book/bookDetail/likeBook")
	public @ResponseBody ResponseEntity like(@RequestBody @Valid FavoriteBookDto favoriteBookDto,
			BindingResult bindingResult, Principal principal) {

		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			for (FieldError fieldError : fieldErrors) {
				sb.append(fieldError.getDefaultMessage());
			}

			return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
		}

		try {
	        String email = principal.getName();
	        Long likeId = favoriteBookService.like(favoriteBookDto, email);
	        return new ResponseEntity<>(likeId.toString(), HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
		
	}

	// 찜 목록
	@RequestMapping(value = "/book/myFavorite")
	public String favoriteBookList() {

		return "/book/myFavorite";
	}

	@GetMapping(value = "/book/myFavorite/{memberId}")
	public String myFavorite(Model model, @PathVariable("memberId") String memberId) {

		Member member = memberRepository.findByUserId(memberId);

		// 사용자의 찜한 도서 목록 가져오기
		List<FavoriteBook> favoriteBooks = favoriteBookService.getFavoriteBooksByMember(member);

		// FavoriteBook 엔티티를 FavoriteBookDto로 변환하여 모델에 추가
		List<FavoriteBookDto> favoriteBookDtos = favoriteBooks.stream().map(FavoriteBookDto::of)
				.collect(Collectors.toList());
		model.addAttribute("favoriteBooks", favoriteBookDtos);

		return "book/myFavorite";
	}

	// 찜 삭제
	@GetMapping(value = "/book/myFavorite/{userId}/remove/{favoriteBookId}")

	public String removeFavoriteBook(@PathVariable("userId") String userId,
			@PathVariable("favoriteBookId") Long favoriteBookId) {
		Member member = memberRepository.findByUserId(userId);

		Book book = favoriteBookService.getBookById(favoriteBookId);

		favoriteBookService.removeFavoriteBook(member, book);

		return "redirect:/book/myFavorite/{userId}";
	}
}

// 리뷰 작성
/*
 * @PostMapping(value = "book/bookDetail/{isbn}/createReview") public String
 * createReview(@PathVariable("isbn") String isbn, BookReviewDto bookReviewDto)
 * {
 * 
 * Book book = bookService.getBookByIsbn(isbn); // BookService를 통해 책 정보 가져오기
 * 
 * Member member = new Member(); member.setMemberName("ㅇㅇ");
 * bookReviewDto.setMember(member); bookReviewDto.setBook(book);
 * bookService.saveReview(bookReviewDto); // 리뷰 저장
 * 
 * return "redirect:/book/bookDetail/{isbn}";
 * 
 * }
 */