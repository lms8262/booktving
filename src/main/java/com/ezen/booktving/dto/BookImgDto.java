package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.BookImg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookImgDto {
	private Long id;
	
	private String imgName;
	
	private String oriImgName;
	
	private YesNoStatus repYn;
	
	private String imgUrl;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	//entity를 DTO로 변환
	public static BookImgDto of(BookImg bookImg) {
		return modelMapper.map(bookImg, BookImgDto.class);
	}
}
