package com.ezen.booktving.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRentDto {
		
	private Long id;  //대여 아이디
	
	private LocalDateTime rentDate; //대여날짜
}
