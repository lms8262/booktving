package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.AuthorBook;

import jakarta.validation.constraints.NotBlank;
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
	
	private AuthorBookImgDto authorBookImgDto = new AuthorBookImgDto();
	
	private AuthorBookImgDto authorBookImgId = new AuthorBookImgDto();
	
	public AuthorBook creAuthorBook(ModelMapper modelMapper) {
		return modelMapper.map(this, AuthorBook.class);
	}
	
	public static AuthorBookDto of(AuthorBook authorBook, ModelMapper modelMapper) {
		return modelMapper.map(authorBook, AuthorBookDto.class);
	}
	
}
