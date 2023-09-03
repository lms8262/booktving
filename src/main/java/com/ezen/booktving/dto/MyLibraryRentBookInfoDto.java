package com.ezen.booktving.dto;

import java.time.LocalDate;


import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.RentBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyLibraryRentBookInfoDto {
	
	private Long id; //대여아이디
	
	private String bookName; //도서명
	
	private String author; //저자명
	
	private String publisher; //출판사명
	
	private LocalDate publicationDate; //출간일
	
	private String  bookIntroduction; //책 소개
	
	private String imgUrl; //도서 이미지
	
	private String review; //한줄 리뷰
	
	private String sentence; //한 문장
	
	private YesNoStatus completeYn;
	
	
	public MyLibraryRentBookInfoDto(RentBook rentBook, BookImg bookImg) {
		this.id = rentBook.getId();
		this.bookName = rentBook.getBook().getBookName();
		this.author = rentBook.getBook().getAuthor();
		this.publisher = rentBook.getBook().getPublisher();
		this.publicationDate = rentBook.getBook().getPublicationDate();
		this.bookIntroduction = rentBook.getBook().getBookIntroduction();
		this.imgUrl = bookImg.getImgUrl();
		this.review = rentBook.getReview();
		this.sentence = rentBook.getSentence();
		this.completeYn = rentBook.getCompleteYn();
	}

}
