package com.ezen.booktving.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.Author;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorFormDto {

	private Long id;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String authorNameKo;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String authorNameEg;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String title;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String authorIntroduction;
	
	@NotBlank(message = "필수입력 값입니다.")
	private String imgUrl;
	
	
	private List<AuthorBookDto> authorBookDtoList = new ArrayList<>();
	
	private List<Long> authorBookIds = new ArrayList<>();
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Author creatAuthor() {
		return modelMapper.map(this, Author.class);
	}
	
	public static AuthorFormDto of(Author author) {
		return modelMapper.map(author, AuthorFormDto.class);
	}
	
}
