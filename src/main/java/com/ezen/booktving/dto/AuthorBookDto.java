package com.ezen.booktving.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

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
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public AuthorBook createAuthorBook() {
		return modelMapper.map(this, AuthorBook.class);
	}
	
	public static AuthorBookDto of(AuthorBook authorBook) {
		return modelMapper.map(authorBook, AuthorBookDto.class);
	}
	
}
