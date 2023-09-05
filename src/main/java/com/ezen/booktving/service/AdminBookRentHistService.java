package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.AdminRentHistBookDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.repository.RentBookRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminBookRentHistService {
	private final ModelMapper modelMapper; 
	private final RentBookRepository rentBookRepository;
	
	@Transactional(readOnly = true)
	public AdminRentHistBookDto getAdminRentBookDtl(Long rentBookId) {
		
		RentBook rentBook = rentBookRepository.findById(rentBookId)
													.orElseThrow(EntityNotFoundException::new);
		
		AdminRentHistBookDto adminRentHistBookDto = AdminRentHistBookDto.of(rentBook, modelMapper);
		
		return adminRentHistBookDto;
	}
	
	@Transactional(readOnly = true)
	public Page<AdminRentHistBookDto> getAdminRentHistPage(BookSearchDto bookSearchDto, Pageable pageable) {
		Page<RentBook> rentBookPage = rentBookRepository.getAdminRentBookPage(bookSearchDto, pageable);
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
		RentBook rentBook = rentBookRepository.findById(rentBookId)
							.orElseThrow(EntityNotFoundException::new);
		
		rentBookRepository.delete(rentBook);
	}
	
	//도서대여정보 가져오기
	public List<RentBook> listAll(){
		List<RentBook> rentBookList = rentBookRepository.findAll();
		
		List<AdminRentHistBookDto> rentBookDtoList = new ArrayList<>();
		
		for(RentBook rentBook : rentBookList) {
			AdminRentHistBookDto renBookDto = AdminRentHistBookDto.of(rentBook, modelMapper);
			rentBookDtoList.add(renBookDto);
		}
		return rentBookList;
	}
	

	
}
