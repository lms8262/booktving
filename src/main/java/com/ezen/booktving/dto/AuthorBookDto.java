package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.AuthorBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorBookDto {

	private Long id;
	
	private String bookName;
	
	private String bookSubTitle;
	
	private String bookIntrodution;
	
	private String imgUrl;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static AuthorBookDto of(AuthorBook authorBook) {
		return modelMapper.map(authorBook, AuthorBookDto.class);
	}
	
}
