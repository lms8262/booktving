package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.BookDto;
import com.ezen.booktving.dto.BookImgDto;
import com.ezen.booktving.dto.BookReviewDto;
import com.ezen.booktving.dto.BookTvingTop10Dto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.BookReview;
import com.ezen.booktving.repository.BookDetailRepository;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.BookRepository;
import com.ezen.booktving.repository.BookReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

	@Autowired
	private final BookRepository bookRepository;
	private final BookDetailRepository bookDetailRepository;
	private final BookImgRepository bookImgRepository;
	private final BookReviewRepository bookReviewRepository;
	
	@Transactional(readOnly = true)
	public BookDto getBookDetail(String isbn) {
		Book book = bookDetailRepository.findByIsbnOrderByIdAsc(isbn);
		
		if (book == null) {
	        // 책 정보가 없을 경우 처리
	        return null; // 또는 예외 처리 등의 로직을 추가
	    }
		
		//책 이미지 가져오기
		List<BookImg> bookImgList = bookImgRepository.findByBookIdOrderByIdAsc(book.getId());
		
		//이미지 엔티티 객체 -> dto로 변환
		List<BookImgDto> bookImgDtoList = new ArrayList<>();
		for(BookImg bookImg : bookImgList) {
			BookImgDto bookImgDto = BookImgDto.of(bookImg);
			bookImgDtoList.add(bookImgDto);
		}
		
		List<BookReview> bookReviewList = bookReviewRepository.findByBookIdOrderByIdAsc(book.getId());
		
		List<BookReviewDto> bookReviewDtoList = new ArrayList<>();
		for(BookReview bookReview : bookReviewList) {
			BookReviewDto bookReviewDto = BookReviewDto.of(bookReview);
			bookReviewDtoList.add(bookReviewDto);
		}
		
		BookDto bookDto = BookDto.of(book);
		bookDto.setBookImgDtoList(bookImgDtoList);
		bookDto.setBookReviewDtoList(bookReviewDtoList);
		
		return bookDto;
						
	}
	
	@Transactional
	public String saveReview(BookReviewDto bookReviewDto) {
		 
	        return bookReviewRepository.save(bookReviewDto.createBookReview()).getContent();
	    }
	
	@Transactional(readOnly = true)
	public Book getBookByIsbn(String isbn) {
	    return bookDetailRepository.findByIsbn(isbn);
	            
	}
	
	@Transactional(readOnly = true)
	public Optional<Book> getBookById(Long id) {
	    return bookDetailRepository.findById(id);
	            
	}
	
	// isbn 값으로 해당 book 엔티티 데이터를 가져옴.
   @Transactional(readOnly = true)
   public Book getBook(String isbn){
      Book book = bookDetailRepository.findByIsbnOrderByIdAsc(isbn);
      return book;
   }
	
	//북티빙 Top10
	//일간
	public Page<BookTvingTop10Dto> getDayBookRankList(Pageable pageable) {
		
		Page<BookTvingTop10Dto> bookTvingTop10Page = bookRepository.getDayBookRankList(pageable);
		
		return bookTvingTop10Page;
	}
	
	//주간
	public Page<BookTvingTop10Dto> getWeekBookRankList(Pageable pageable) {
			
		Page<BookTvingTop10Dto> bookTvingTop10Page = bookRepository.getWeekBookRankList(pageable);
			
		return bookTvingTop10Page;
	}
		
	//월간
	public Page<BookTvingTop10Dto> getMonthBookRankList(Pageable pageable) {
			
		Page<BookTvingTop10Dto> bookTvingTop10Page = bookRepository.getMonthBookRankList(pageable);
			
		return bookTvingTop10Page;
	}
		
	//연간
	public Page<BookTvingTop10Dto> getYearBookRankList(Pageable pageable) {
			
		Page<BookTvingTop10Dto> bookTvingTop10Page = bookRepository.getYearBookRankList(pageable);
			
		return bookTvingTop10Page;
	}
}
