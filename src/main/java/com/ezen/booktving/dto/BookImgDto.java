package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;

import lombok.*;

@Getter
@Setter
public class BookImgDto {

	private Long id;
	
	private String imgName;
	
	private String oriImgName;
	
	private YesNoStatus repYn;
	
	private String imgUrl;
	
	private Book book;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public BookImg createBookImg() {
		return modelMapper.map(this, BookImg.class);
	}
	
	public static BookImgDto of(BookImg bookImg) {
		return modelMapper.map(bookImg, BookImgDto.class);
	}
}
