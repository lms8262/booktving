package com.ezen.booktving.dto;

import java.util.List;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorFormDto {

	 @Valid
	 private AuthorDto authorDto;

	 @Valid
	 private List<AuthorBookDto> authorBookDtoList;
	
}
