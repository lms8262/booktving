package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.NewBookTving;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewBookTvingDto {

	
	private Long id;
	
	@NotBlank
	private String title;

	@NotBlank
	private String isbn;
	
	@NotBlank
	private String author;
	
	@NotBlank
	private String publisher;
	
	@NotBlank
	private String imgUrl;
	
	@NotBlank
	private String link;
	
	@NotBlank
	private String description;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	// Dto -> Entity 변환
	public NewBookTving createNewBookTving() {
		return modelMapper.map(this, NewBookTving.class);
	}
	
	// Entity -> Dto 변환
	public static NewBookTvingDto of(NewBookTving newBookTving) {
		return modelMapper.map(newBookTving, NewBookTvingDto.class);
	}
}
