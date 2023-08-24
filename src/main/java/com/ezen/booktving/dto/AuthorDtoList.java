package com.ezen.booktving.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDtoList {

	private Long id;
	
	private String authorNameKo;
	
	private String authorNameEg;
	
	private String title;
	
	private String authorIntroduction;
	
	private String imgUrl;
	
	@QueryProjection
	public AuthorDtoList(Long id, String authorNameKo, String authorNameEg, String title, String authorIntroduction, String imgUrl) {
		this.id = id;
		this.authorNameKo = authorNameKo;
		this.authorNameEg = authorNameEg;
		this.title = title;
		this.authorIntroduction = authorIntroduction;
		this.imgUrl = imgUrl;
	}
	
}
