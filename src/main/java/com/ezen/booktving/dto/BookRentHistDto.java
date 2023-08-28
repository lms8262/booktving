package com.ezen.booktving.dto;

import java.time.format.DateTimeFormatter;

import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.RentBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRentHistDto {
	
	private Long id;  //대여 아이디
	
	private String rentDate; //대여날짜
	
	private String bookName;  //도서명
	
	private String author;   //저자명
	
	private String publisher; //출판사명
	
	private String imgUrl; //도서이미지
	
	
	public BookRentHistDto(RentBook rentBook, BookImg bookImg) {
		this.id = rentBook.getId();
		this.rentDate = rentBook.getRentDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		this.bookName = rentBook.getBook().getBookName();
		this.author = rentBook.getBook().getAuthor();
		this.publisher = rentBook.getBook().getPublisher();
		this.imgUrl = bookImg.getImgUrl();
	}
	
	
}
