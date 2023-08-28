package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.FavoriteAuthor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteAuthorDto {

	private String memberId;
	
	private String authorId;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static FavoriteAuthorDto of(FavoriteAuthor favoriteAuthor) {
		return modelMapper.map(favoriteAuthor, FavoriteAuthorDto.class);
	}
}
