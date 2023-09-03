package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookImgDto;
import com.ezen.booktving.dto.BookReviewDto;
import com.ezen.booktving.dto.BookTvingTop10Dto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.BookReview;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.BookRepository;
import com.ezen.booktving.repository.BookReviewRepository;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.repository.RentBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
	
	private final ModelMapper modelMapper;
	private final BookRepository bookRepository;
	private final BookImgRepository bookImgRepository;
	private final BookReviewRepository bookReviewRepository;
	private final RentBookRepository rentRepository;
	private final MemberRepository memberRepository;
	
	//책정보 가져오기
	@Transactional(readOnly = true)
	public BookDto getBookDetail(String isbn) {
		Book book = bookRepository.findByIsbn(isbn);
		
		if (book == null) {
	        // 책 정보가 없을 경우 처리
	        return null; // 또는 예외 처리 등의 로직을 추가
	    }
		
		//책 이미지 가져오기
		List<BookImg> bookImgList = bookImgRepository.findByBookIdOrderByIdAsc(book.getId());
		
		//이미지 엔티티 객체 -> dto로 변환
		List<BookImgDto> bookImgDtoList = new ArrayList<>();
		for(BookImg bookImg : bookImgList) {
			BookImgDto bookImgDto = BookImgDto.of(bookImg, modelMapper);
			bookImgDtoList.add(bookImgDto);
		}
		
		List<BookReview> bookReviewList = bookReviewRepository.findByBookIdOrderByIdAsc(book.getId());
		
		List<BookReviewDto> bookReviewDtoList = new ArrayList<>();
		for(BookReview bookReview : bookReviewList) {
			BookReviewDto bookReviewDto = BookReviewDto.builder()
					.id(bookReview.getId())
					.userId(bookReview.getMember().getUserId())
					.content(bookReview.getContent())
					.build();
			bookReviewDtoList.add(bookReviewDto);
		}
		
		BookDto bookDto = BookDto.of(book, modelMapper);
		bookDto.setBookImgDtoList(bookImgDtoList);
		bookDto.setBookReviewDtoList(bookReviewDtoList);
		
		return bookDto;
						
	}
	
	//리뷰 저장하기
	public void saveReview(BookReviewDto bookReviewDto, String userId, String isbn) {	 
		Member member = memberRepository.findByUserId(userId);
		Book book = bookRepository.findByIsbn(isbn);
		
		BookReview bookReview = BookReview.builder()
				.content(bookReviewDto.getContent())
				.book(book)
				.member(member)
				.build();
		
		bookReviewRepository.save(bookReview);
    }
	
	//북티빙 Top10
	//일간
	public List<BookTvingTop10Dto> getDayBookRankList() {
		
		List<BookTvingTop10Dto> bookTvingTop10Page = rentRepository.getDayBookRankList();
		
		return bookTvingTop10Page;
	}
	
	//주간
	public List<BookTvingTop10Dto> getWeekBookRankList() {
			
		List<BookTvingTop10Dto> bookTvingTop10Page = rentRepository.getWeekBookRankList();
			
		return bookTvingTop10Page;
	}
		
	//월간
	public List<BookTvingTop10Dto> getMonthBookRankList() {
			
		List<BookTvingTop10Dto> bookTvingTop10Page = rentRepository.getMonthBookRankList();
			
		return bookTvingTop10Page;
	}
		
	//연간
	public List<BookTvingTop10Dto> getYearBookRankList() {
			
		List<BookTvingTop10Dto> bookTvingTop10Page = rentRepository.getYearBookRankList();
			
		return bookTvingTop10Page;
	}
	

	
}
