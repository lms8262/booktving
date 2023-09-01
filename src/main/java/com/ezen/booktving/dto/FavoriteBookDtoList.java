package com.ezen.booktving.dto;

import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;

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
	
	private Member member;

	private Book book;

	public FavoriteBookDtoList(FavoriteBook favoriteBook, BookImg bookImg) {
		this.id = favoriteBook.getId();
		this.isbn = favoriteBook.getBook().getIsbn();
		this.bookName = favoriteBook.getBook().getBookName();
		this.author = favoriteBook.getBook().getAuthor();
		this.imgUrl = bookImg.getImgUrl();
	}
}
