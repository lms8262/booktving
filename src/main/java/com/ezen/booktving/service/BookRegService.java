package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.BookImgDto;
import com.ezen.booktving.dto.BookRegFormDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BookRegService {
	private final BookRepository bookRepository;
	private final BookImgService bookImgService;
	private final BookImgRepository bookImgRepository;
	
	//book 테이블에 상품등록
	public Long saveBook(BookRegFormDto bookRegFormDto, List<MultipartFile> bookImgFileList) throws Exception {
		
		//1. 상품등록
		Book book = bookRegFormDto.createBook(); //dto -> entity
		bookRepository.save(book); //insert 저장
		
		//2. 이미지 등록
		for(int i=0; i<bookImgFileList.size(); i++) {
			//fk키 사용시 부모테이블에 해당하는 entity 먼저 사용
			BookImg bookImg = new BookImg();
			bookImg.setBook(book);
			
			//첫번째 이미지 일때 대표도서 이미지 지정
			if(i == 0) {
				bookImg.setRepYn(YesNoStatus.Y);
			} else {
				bookImg.setRepYn(YesNoStatus.N);
			}
			
			bookImgService.saveBookImg(bookImg, bookImgFileList.get(i));
		}
		
		return book.getId(); //등록한 도서 id 리턴
	}
	
	//도서를 가져오는 기능을 할 서비스
	@Transactional(readOnly = true)
	public BookRegFormDto getBookDtl(Long bookId) {
		
		//1.book_img 테이블의 이미지를 가져온다.
		List<BookImg> bookimgList = bookImgRepository.findByBookIdOrderByIdAsc(bookId);
		
		//bookImg 엔티티 객체 -> bookImgDto로 변환
		List<BookImgDto> bookimgDtoList = new ArrayList<>();
		for(BookImg bookImg : bookimgList) {
			BookImgDto bookImgDto = BookImgDto.of(bookImg);
			bookimgDtoList.add(bookImgDto);
		}
		
		//2. book 테이블에 있는 데이터를 가져온다.
		Book book = bookRepository.findById(bookId)
						.orElseThrow(EntityNotFoundException::new);
		
		//book 엔티티 객체 -> dto로 변환
		BookRegFormDto bookRegFormDto = BookRegFormDto.of(book);
		
		//3. BookRegFormDto에 이미지 정보 (bookImgDtoList)를 넣어준다.
		bookRegFormDto.setBookImgDtoList(bookimgDtoList);
		
		return bookRegFormDto;
		
	
	}
	
	public Long updateBook(BookRegFormDto bookRegFormDto, List<MultipartFile> bookImgFileList) throws Exception {
		
		//1.book 엔티티 가져와서 바꾼다.
		Book book = bookRepository.findById(bookRegFormDto.getId())
									.orElseThrow(EntityNotFoundException::new);
		
		book.updateBook(bookRegFormDto);
		
		//2.book_img를 바꿔준다 
		List<Long> bookImgIds = bookRegFormDto.getBookImgIds(); 
		
		for(int i=0; i<bookImgFileList.size(); i++) {
			bookImgService.updateBookImg(bookImgIds.get(i), bookImgFileList.get(i));
		}
		
		return book.getId(); //변경한 book의 id 리턴
	}
	
	@Transactional(readOnly = true)
	public Page<Book> getAdminBookPage(BookSearchDto bookSearchDto, Pageable pageable) {
		Page<Book> bookPage = bookRepository.getAdminBookPage(bookSearchDto, pageable);
		List<Book> bookList = bookPage.getContent();
		
		return bookPage;
	}
	
	//도서 상세페이지 삭제
	public void deleteBooks(Long bookId) {
		Book book = bookRepository.findById(bookId)
						.orElseThrow(EntityNotFoundException::new);
		List<BookImg> bookImgList = bookImgRepository.findByBookIdOrderByIdAsc(bookId);
		bookImgRepository.deleteAll(bookImgList);
		
		bookRepository.delete(book);
	} 
	
}
