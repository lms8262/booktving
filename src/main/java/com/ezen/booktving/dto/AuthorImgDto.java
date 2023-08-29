package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.AuthorImg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorImgDto {

	private Long id;
	
	private String imgName;
	
	private String oriImgName;
	
	private String imgUrl;
	
	public static AuthorImgDto of(AuthorImg authorImg, ModelMapper modelMapper) {
		return modelMapper.map(authorImg, AuthorImgDto.class);
	}
	
}
