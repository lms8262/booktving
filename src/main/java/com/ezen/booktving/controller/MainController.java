package com.ezen.booktving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.booktving.dto.AuthorDtoList;
import com.ezen.booktving.dto.BookTvingTop10Dto;
import com.ezen.booktving.entity.BestSeller;
import com.ezen.booktving.entity.NewBookTving;
import com.ezen.booktving.entity.Notice;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.service.AdminBookRentHistService;
import com.ezen.booktving.service.AuthorService;
import com.ezen.booktving.service.BestSellerService;
import com.ezen.booktving.service.BookService;
import com.ezen.booktving.service.NewBookTvingService;
import com.ezen.booktving.service.NoticeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final BestSellerService bestSellerService;
	private final NewBookTvingService newBookTvingService;
	private final BookService bookService;
	private final AuthorService authorService;
	private final AdminBookRentHistService adminBookRentHistService;
	private final NoticeService noticeService;
	
	@GetMapping(value = "/")
	public String main(Optional<Integer> page, Model model) {
		
		//공지사항
		Pageable pageable3 = PageRequest.of(page.isPresent() ? page.get() : 0 , 1);
		Page<Notice> notice = noticeService.getMainNoticePage(pageable3);
		model.addAttribute("notice", notice);
		
		//북티빙 top10
		//th:if="${not #lists.isEmpty(rentBooks)}"
		List<RentBook> rentBooks = adminBookRentHistService.listAll();
		model.addAttribute("rentBooks", rentBooks);
		//일간
		List<BookTvingTop10Dto> dayRanks = bookService.getDayBookRankList();
		model.addAttribute("dayRanks", dayRanks);
		//주간
		List<BookTvingTop10Dto> weekRanks = bookService.getWeekBookRankList();
		model.addAttribute("weekRanks", weekRanks);
		//월간
		List<BookTvingTop10Dto> monthRanks = bookService.getMonthBookRankList();
		model.addAttribute("monthRanks", monthRanks);
		//연간
		List<BookTvingTop10Dto> yearRanks = bookService.getYearBookRankList();
		model.addAttribute("yearRanks", yearRanks);
			
		
		//NEW 북티빙		
		//상위 4개만 가져오기
		Pageable pageable2 = PageRequest.of(page.isPresent() ? page.get() : 0 , 4);
		Page<NewBookTving> newBookTvings = newBookTvingService.getNewBookTving(pageable2);
		model.addAttribute("newBooks", newBookTvings);

		//랜덤 4개 가져오기
		//List<NewBookTving> randomNewBooks = newBookTvingService.getRandomNewBook(4);
		//model.addAttribute("randomNewBooks", randomNewBooks);
		
		//북티빙이 사랑한 작가
		Pageable pageable4 = PageRequest.of(page.isPresent() ? page.get() : 0 , 4);
		Page<AuthorDtoList> authors = authorService.getAuthorPage(pageable4);
		model.addAttribute("authors", authors);
		
		//서점 베스트셀러
		Pageable pageable1 = PageRequest.of(page.isPresent() ? page.get() : 0 , 10);
		Page<BestSeller> bestSellers = bestSellerService.getBestSeller(pageable1);
		model.addAttribute("bestSellers", bestSellers);
		
		return "main";
	}
	
}
