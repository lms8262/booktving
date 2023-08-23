package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.AdminRentHistBookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.repository.AdminBookRentHistRepository;
import com.ezen.booktving.repository.RentRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminBookRentHistService {
	private final AdminBookRentHistRepository adminBookRentHistRepository;
	private final RentRepository rentRepository;
	
	@Transactional(readOnly = true)
	public AdminRentHistBookDto getAdminRentBookDtl(Long rentBookId) {
		
		RentBook rentBook = adminBookRentHistRepository.findById(rentBookId)
													.orElseThrow(EntityNotFoundException::new);
		
		AdminRentHistBookDto adminRentHistBookDto = AdminRentHistBookDto.of(rentBook);
		
		return adminRentHistBookDto;
	}
	
	@Transactional(readOnly = true)
	public Page<AdminRentHistBookDto> getAdminRentHistPage(BookSearchDto bookSearchDto, Pageable pageable) {
		Page<RentBook> rentBookPage = adminBookRentHistRepository.getAdminRentBookPage(bookSearchDto, pageable);
		List<RentBook> rentBookList = rentBookPage.getContent();
		
		List<AdminRentHistBookDto> rentBooks = new ArrayList<>();
		for(RentBook rentBook : rentBookList) {
			AdminRentHistBookDto adminRentHistBookDto = new AdminRentHistBookDto(rentBook);
			rentBooks.add(adminRentHistBookDto);
		}
		
		return new PageImpl<>(rentBooks, pageable, rentBookPage.getTotalElements());
	}
	
	//대출내역 삭제
	public void deleteAdminRentBook(Long rentBookId) {
		RentBook rentBook = rentRepository.findById(rentBookId)
							.orElseThrow(EntityNotFoundException::new);
		
		rentRepository.delete(rentBook);
	}
	
}
