package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.MyLibraryRentBookInfoDto;
import com.ezen.booktving.dto.MyLibraryRentBookListDto;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.RentBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MyLibraryRentBookService {
	private final RentBookRepository rentBookRepository;
	private final BookImgRepository bookImgRepository;
	
	
	//대여목록 리스트 가져오는 서비스
	@Transactional(readOnly = true)
	public Page<MyLibraryRentBookListDto> getMyLibraryRentBookList(String userId, Pageable pageable) {
		
		List<RentBook> rentbooks = rentBookRepository.findRents(userId, pageable);
		
		Long totalCount = rentBookRepository.countRent(userId);
		
		List<MyLibraryRentBookListDto> myLibraryRentBookListDtos = new ArrayList<>();
		
		for(RentBook rentBook : rentbooks) {
			MyLibraryRentBookListDto myLibraryRentBookListDto = new MyLibraryRentBookListDto(rentBook, bookImgRepository.findByBookIdAndRepYn(rentBook.getBook().getId(), YesNoStatus.Y));
			
			myLibraryRentBookListDtos.add(myLibraryRentBookListDto);
		}
		
		return new PageImpl<>(myLibraryRentBookListDtos, pageable, totalCount);
	}
	
	//대여도서 상세페이지 가져오는 서비스
	@Transactional(readOnly = true)
	public Page<MyLibraryRentBookInfoDto> getMyLibraryRentBookInfo(String userId, Pageable pageable) {
		
		List<RentBook> rentbookInfo = rentBookRepository.findRents(userId, pageable);
		
		Long totalCount = rentBookRepository.countRent(userId);
		
		List<MyLibraryRentBookInfoDto> myLibraryRentBookInfoDtos  = new ArrayList<>();
		
		for(RentBook rentBook : rentbookInfo) {
			MyLibraryRentBookInfoDto myLibraryRentBookInfoDto = new MyLibraryRentBookInfoDto(rentBook, bookImgRepository.findByBookIdAndRepYn(rentBook.getBook().getId(), YesNoStatus.Y));
			
			myLibraryRentBookInfoDtos.add(myLibraryRentBookInfoDto);
		}
		
		return new PageImpl<>(myLibraryRentBookInfoDtos, pageable, totalCount);
	} 
	
}
