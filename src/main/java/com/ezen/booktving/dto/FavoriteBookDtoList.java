package com.ezen.booktving.dto;

import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.FavoriteBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteBookDtoList {
	
	private Long id;
	
	private String isbn;
	
	private String bookName;
	
	private String author;
	
	private String imgUrl;

	public FavoriteBookDtoList(FavoriteBook favoriteBook, BookImg bookImg) {
		this.id = favoriteBook.getId();
		this.isbn = favoriteBook.getBook().getIsbn();
		this.bookName = favoriteBook.getBook().getBookName();
		this.author = favoriteBook.getBook().getAuthor();
		this.imgUrl = bookImg.getImgUrl();
	}
}
