package com.ezen.booktving.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;

import lombok.*;

@Getter
@Setter
public class FavoriteBookDto {

	private Long id;

	private String isbn;

	private String bookName;

	private String author;

	private Member member;

	private Book book;

	private List<BookImgDto> bookImgDtoList;

	private static ModelMapper modelMapper = new ModelMapper();

	private List<FavoriteBookDto> favoriteBookDtoList = new ArrayList<>();

	public FavoriteBookDto() {
		// 기본 생성자
	}

	public FavoriteBookDto(Long id, String isbn, String bookName, String author, Member member, Book book) {
		this.id = id;
		this.isbn = isbn;
		this.bookName = bookName;
		this.author = author;
		this.member = member;
		this.book = book;
	}


	public static FavoriteBookDto of(FavoriteBook favoriteBook) {
		FavoriteBookDto dto = modelMapper.map(favoriteBook, FavoriteBookDto.class);
		dto.setIsbn(favoriteBook.getBook().getIsbn());
		return dto;
	}
	
	
}
