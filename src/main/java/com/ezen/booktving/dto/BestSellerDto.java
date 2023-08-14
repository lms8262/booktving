package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.BestSeller;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BestSellerDto {

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
	private String bestRank;
	
	@NotBlank
	private String imgUrl;
	
	@NotBlank
	private String link;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	// Dto -> Entity 변환
	public BestSeller createBestSeller() {
		return modelMapper.map(this, BestSeller.class);
	}
	
	// Entity -> Dto 변환
	public static BestSellerDto of(BestSeller bestSeller) {
		return modelMapper.map(bestSeller, BestSellerDto.class);
	}
	
	
	
	
}
