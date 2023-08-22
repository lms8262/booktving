package com.ezen.booktving.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchBookDto {
	
	private Long id;
	
	private String bookName;
	
	private String isbn;
	
	private String author;
	
	private String imgUrl;
	
	@QueryProjection
	public SearchBookDto(Long id, String bookName, String isbn, String author, String imgUrl) {
		this.id = id;
		this.bookName = bookName;
		this.isbn = isbn;
		this.author = author;
		this.imgUrl = imgUrl;
	}
}
