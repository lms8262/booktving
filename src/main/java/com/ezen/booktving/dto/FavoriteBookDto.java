package com.ezen.booktving.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FavoriteBookDto {

	private Long id;

	private String isbn;

	private String bookName;

	private String author;

	private List<BookImgDto> bookImgDtoList;

	public FavoriteBookDto(Long id, String isbn, String bookName, String author, Member member, Book book) {
		this.id = id;
		this.isbn = isbn;
		this.bookName = bookName;
		this.author = author;
	}

	public static FavoriteBookDto of(ModelMapper modelMapper, FavoriteBook favoriteBook) {
		FavoriteBookDto dto = modelMapper.map(favoriteBook, FavoriteBookDto.class);
		dto.setIsbn(favoriteBook.getBook().getIsbn());
		return dto;
	}
	
}
