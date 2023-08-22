package com.ezen.booktving.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Author;
import com.ezen.booktving.entity.AuthorBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorFormDto {

	private Long id;
	
	private String authorNameKo;
	
	private String authorNameEg;
	
	private String title;
	
	private String authorIntroduction;
	
	private List<AuthorBookDto> authorBookDtoList = new ArrayList<>();
	
	private AuthorImgDto authorImgDto = new AuthorImgDto();
	
	private AuthorImgDto authorImgId = new AuthorImgDto();
	
	private List<Long> authorBookIds = new ArrayList<>();
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Author createAuthor() {
		return modelMapper.map(this, Author.class);
	}
	
	public AuthorBook createAuthorBook() {
		return modelMapper.map(this, AuthorBook.class);
	}
	
	public static AuthorFormDto of(Author author) {
		return modelMapper.map(author, AuthorFormDto.class);
	}
	
	
}
