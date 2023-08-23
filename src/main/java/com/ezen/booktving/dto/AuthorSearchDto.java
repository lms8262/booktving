package com.ezen.booktving.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorSearchDto {

	private String searchBy;	
	private String searchQuery = "";
	
}
