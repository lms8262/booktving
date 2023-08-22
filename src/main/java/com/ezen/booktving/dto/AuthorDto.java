package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.booktving.entity.Author;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {


	private Long id;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String authorNameKo;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String authorNameEg;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String title;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String authorIntroduction;
	
	private MultipartFile authorImgFile;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String oriImgName;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String imgUrl;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Author createAuthor() {
		return modelMapper.map(this, Author.class);
	}
	
	public static AuthorDto of(Author author) {
		return modelMapper.map(author, AuthorDto.class);
	}
	
}
