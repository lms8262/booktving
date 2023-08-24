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
	
	private String isbn;
	
	private String bookName;
	
	private String author;
	
	private Member member;

	private Book book;
	
	private static ModelMapper modelMapper = new ModelMapper();

	/*public FavoriteBook createFavoriteBook() {
		FavoriteBook favoriteBook = new FavoriteBook();
		favoriteBook.setMember(this.member); // Set the member
	    favoriteBook.setId(this.id); // Set the bookId
	    
	    return favoriteBook;
	}*/

	public static FavoriteBookDto of(FavoriteBook favoriteBook) {
		FavoriteBookDto dto = modelMapper.map(favoriteBook, FavoriteBookDto.class);
		dto.setIsbn(favoriteBook.getBook().getIsbn()); 
		return dto;
	}
}
