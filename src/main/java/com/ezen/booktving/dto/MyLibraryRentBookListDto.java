package com.ezen.booktving.dto;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.RentBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyLibraryRentBookListDto {
	
	private Long id; //대여아이디
	
	private String bookName; //도서명
	
	private String author; //저자명
	
	private String publisher; //출판사명
	
	private String category; //카테고리
	
	private String complete; //완독여부
	
	private String imgUrl;  //도서이미지
	
	
	public MyLibraryRentBookListDto(RentBook rentBook, BookImg bookImg) {
		this.id = rentBook.getId();
		this.bookName = rentBook.getBook().getBookName();
		this.author = rentBook.getBook().getAuthor();
		this.publisher = rentBook.getBook().getPublisher();
		this.category = rentBook.getBook().getCategory();
		if(rentBook.getCompleteYn().equals(YesNoStatus.Y)) {
			this.complete = "완독";
		} else if (rentBook.getCompleteYn().equals(YesNoStatus.N)){
			this.complete = "미완독";
		}
		this.imgUrl = bookImg.getImgUrl();
	}
}
