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
	
	private AuthorBookImgDto authorBookImgId = new AuthorBookImgDto();
	
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public AuthorBookImg createAuthorBookImg() {
		return modelMapper.map(this, AuthorBookImg.class);
	}
	
	public static AuthorBookImgDto of(AuthorBookImg authorBookImg) {
		return modelMapper.map(authorBookImg, AuthorBookImgDto.class);
	}

}
