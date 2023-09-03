package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.YesNoStatus;

import com.ezen.booktving.entity.BookImg;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookImgDto {

	private Long id;
	
	private String imgName;
	
	private String oriImgName;
	
	private YesNoStatus repYn;
	
	private String imgUrl;
	
	public BookImg createBookImg(ModelMapper modelMapper) {
		return modelMapper.map(this, BookImg.class);
	}
	
	public static BookImgDto of(BookImg bookImg, ModelMapper modelMapper) {
		return modelMapper.map(bookImg, BookImgDto.class);
	}
}
