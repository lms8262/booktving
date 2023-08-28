package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.AuthorBookImg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorBookImgDto {

	private Long id;
	
	private String imgName;
	
	private String oriImgName;
	
	private String imgUrl;
	
	public static AuthorBookImgDto of(AuthorBookImg authorBookImg, ModelMapper modelMapper) {
		return modelMapper.map(authorBookImg, AuthorBookImgDto.class);
	}

}
