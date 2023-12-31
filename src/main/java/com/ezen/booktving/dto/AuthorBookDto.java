package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Author;
import com.ezen.booktving.entity.AuthorBook;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorBookDto {


	private Long id;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String bookName;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String bookSubTitle;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String bookIntrodution;
	
	@NotNull(message = "작가는 필수 선택입니다.")
	private Author author;
	
	private AuthorBookImgDto authorBookImgDto = new AuthorBookImgDto();
	
	private AuthorBookImgDto authorBookImgId = new AuthorBookImgDto();
	
	public AuthorBook createAuthorBook(ModelMapper modelMapper) {
		return modelMapper.map(this, AuthorBook.class);
	}
	
	public static AuthorBookDto of(AuthorBook authorBook, ModelMapper modelMapper) {
		return modelMapper.map(authorBook, AuthorBookDto.class);
	}
	
}
