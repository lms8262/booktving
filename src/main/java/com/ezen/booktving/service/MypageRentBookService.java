package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.BookImgDto;
import com.ezen.booktving.dto.BookRentHistDto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.BookRepository;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.repository.RentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MypageRentBookService {
	private final RentRepository rentRepository;
	private final BookRepository bookRepository;
	private final MemberRepository memberRepository;
	private final BookImgRepository bookImgRepository;
	
	//대여목록 가져오는 서비스
	@Transactional(readOnly = true)
	public Page<BookRentHistDto> getBookRentHistList(String userId, Pageable pageable) {
		
		//1. 유저 아이디와 페이징 조건을 이용하여 대여 목록을 조회
		List<RentBook> rentbooks = rentRepository.findRents(userId, pageable);
		
		//2. 유저의 대여 총 개수를 구한다
		Long totalCount = rentRepository.countRent(userId);
		
		List<BookRentHistDto> bookRentHistDtos = new ArrayList<>();
		
		//3. 대여 리스트를 순회하면서 대여 이력 페이제 전달할 DTO 생성
		for (RentBook rentBook : rentbooks) {
			BookRentHistDto bookRentHistDto = new BookRentHistDto(rentBook, bookImgRepository.findByBookIdAndRepYn(rentBook.getBook().getId(), YesNoStatus.Y));
			
			bookRentHistDtos.add(bookRentHistDto);
		}
		
		return new PageImpl<>(bookRentHistDtos, pageable, totalCount);
	}
}
