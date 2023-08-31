package com.ezen.booktving.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.repository.BookRepository;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.repository.RentBookRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RentBookService {
	
	private final RentBookRepository rentBookRepository;
	private final MemberRepository memberRepository;
	private final BookRepository bookRepository;
	
	public Long saveRentBook(String userId, String isbn) {
		Member member = memberRepository.findByUserId(userId);
		Book book = bookRepository.findByIsbn(isbn);
		
		if(member == null || book == null) {
			throw new EntityNotFoundException();
		}
		
		RentBook findRentBook = rentBookRepository.getRentBookByUserIdAndIsbn(userId, isbn);
		
		if(findRentBook != null) { // 이미 대여한 도서인 경우
			return -1L;
		}
		
		RentBook rentBook = RentBook.builder()
									.rentDate(LocalDateTime.now())
									.completeYn(YesNoStatus.N)
									.member(member)
									.book(book)
									.build();
		rentBookRepository.save(rentBook);
		return rentBook.getId();
	}
}
