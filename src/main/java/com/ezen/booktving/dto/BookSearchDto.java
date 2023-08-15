package com.ezen.booktving.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSearchDto {
	
	private String searchIsbn;
	private String searchBy;
	private String searchQuery = "" ;
}
