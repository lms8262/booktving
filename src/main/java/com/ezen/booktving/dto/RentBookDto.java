package com.ezen.booktving.dto;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.RentBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentBookDto {

	private Long id;
	
	private LocalDateTime rentDate;
	
	private String review;
	
	private String sentence;
	
	private YesNoStatus completeYn;
	
	public RentBookDto(RentBook rentBook) {
	}

	public RentBook createRentBook(ModelMapper modelMapper) {
		return modelMapper.map(this, RentBook.class);
	}
	
	public static RentBookDto of(RentBook rentBook, ModelMapper modelMapper) {
		return modelMapper.map(rentBook, RentBookDto.class);
	}
	
}
