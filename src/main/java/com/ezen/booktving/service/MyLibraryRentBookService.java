package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.AdminRentHistBookDto;
import com.ezen.booktving.dto.MyLibraryRentBookInfoDto;
import com.ezen.booktving.dto.MyLibraryRentBookListDto;
import com.ezen.booktving.dto.RentBookDto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.RentBookRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MyLibraryRentBookService {
	private final ModelMapper modelMapper;
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
	public MyLibraryRentBookInfoDto getMyLibraryRentBookInfo(Long rentBookId) {
		
		RentBook rentBook = rentBookRepository.findById(rentBookId).orElseThrow(EntityNotFoundException::new);
		
		MyLibraryRentBookInfoDto myLibraryRentBookInfoDto = new MyLibraryRentBookInfoDto(rentBook, bookImgRepository.findByBookIdAndRepYn(rentBook.getBook().getId(), YesNoStatus.Y));
		
		return myLibraryRentBookInfoDto;
	} 
	
	//대여도서 독서완료 등록하기
	@Transactional
	public void rentBookComplete(Long rentBookId) {
		RentBook rentBook = rentBookRepository.findById(rentBookId).orElseThrow(EntityNotFoundException::new);
		
		YesNoStatus currentStatus = rentBook.getCompleteYn();
		
		if(currentStatus == YesNoStatus.N) {
			rentBook.setCompleteYn(YesNoStatus.Y);
		} else {
			rentBook.setCompleteYn(YesNoStatus.N);
		}
			rentBookRepository.save(rentBook);
	}
	
	//대여도서 상세페이지 리뷰등록하기
	@Transactional
	public void addReview(Long rentBookId, String reviewText) {
		RentBook rentBook = rentBookRepository.findById(rentBookId).orElseThrow(EntityNotFoundException::new);
	        
        rentBook.setReview(reviewText);	        
        rentBookRepository.save(rentBook);
    }
	
	//대여도서 상세페이지 리뷰삭제하기
	@Transactional
	public void deleteReview(Long rentBookId) {
		RentBook rentBook = rentBookRepository.findById(rentBookId).orElseThrow(EntityNotFoundException::new);
	        
	    rentBook.setReview(null);
	    rentBookRepository.save(rentBook);
	}
	
	//대여도서 상세페이지 한문장 등록하기
	@Transactional
	public void addSentence(Long rentBookId, String sentence) {
		RentBook rentBook = rentBookRepository.findById(rentBookId).orElseThrow(EntityNotFoundException::new);
		
		rentBook.setSentence(sentence);
		rentBookRepository.save(rentBook);
	}
	
	//대여도서 상세페이지 한문장 삭제하기
	@Transactional
	public void deleteSentence(Long rentBookId) {
		RentBook rentBook = rentBookRepository.findById(rentBookId).orElseThrow(EntityNotFoundException::new);
        
        rentBook.setSentence(null);
        rentBookRepository.save(rentBook);
    }
	
	//로그인한 사용자의 도서대여정보 가져오기-나의서재 메인
	public List<RentBook> listAll(String userId){
		List<RentBook> rentBookList = rentBookRepository.findRentByMember(userId);
		
		List<AdminRentHistBookDto> rentBookDtoList = new ArrayList<>();
		
		for(RentBook rentBook : rentBookList) {
			AdminRentHistBookDto rentBookDto = AdminRentHistBookDto.of(rentBook, modelMapper);
			rentBookDtoList.add(rentBookDto);
		}
		return rentBookList;
	}
	
	//챌린지 페이지에서 rentbook 가져오기
	public List<RentBookDto> getMyRentBookList(String userId){
		List<RentBook> rentBooks = rentBookRepository.findByCompleteYnAndMember_UserId(YesNoStatus.Y, userId);
		
		List<RentBookDto> rentBookDtoList = new ArrayList<>();
		
		for(RentBook rentBook : rentBooks) {
			RentBookDto rentBookDto = new RentBookDto(rentBook);
			rentBookDtoList.add(rentBookDto);
		}
		return rentBookDtoList;
	}
	
	public long getCountOfCompletedRentBooks(String userId) {
        return rentBookRepository.countByCompleteYnAndMember_UserId(YesNoStatus.Y, userId);
    }

	
}
