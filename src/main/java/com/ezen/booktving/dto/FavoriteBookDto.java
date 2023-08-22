package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;

import lombok.*;

@Getter
@Setter
public class FavoriteBookDto {

	private Long id;

	private Long bookId;
	
	private Member member;

	private Book book;

	private static ModelMapper modelMapper = new ModelMapper();

	public FavoriteBook createFavoriteBook() {
		return modelMapper.map(this, FavoriteBook.class);
	}

	public static FavoriteBookDto of(FavoriteBook favoriteBook) {
		FavoriteBookDto dto = modelMapper.map(favoriteBook, FavoriteBookDto.class);
		dto.setId(favoriteBook.getBook().getId()); // 이 부분 추가
		return dto;
	}
}
