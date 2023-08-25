package com.ezen.booktving.dto;

import java.time.format.DateTimeFormatter;

import com.ezen.booktving.entity.RecommendKeyword;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KeywordDto {
	
	private Long id;
	
	private String keywordType;
	
	private String keywordName;
	
	// 사용자에게 보여줄땐 등록일에 보임
	private String updateTime;
	
	public static KeywordDto createKeywordDto(RecommendKeyword recommendKeyword) {
		KeywordDto keywordDto = new KeywordDto();
		keywordDto.setId(recommendKeyword.getId());
		String keywordType = recommendKeyword.getRecommendKeywordType();
		if(keywordType.equals("Keyword")) {
			keywordDto.setKeywordType("제목+저자");
		}
		if(keywordType.equals("Title")) {
			keywordDto.setKeywordType("제목");
		}
		if(keywordType.equals("Author")) {
			keywordDto.setKeywordType("저자");
		}
		if(keywordType.equals("Publisher")) {
			keywordDto.setKeywordType("출판사");
		}
		
		keywordDto.setKeywordName(recommendKeyword.getRecommendKeywordName());
		keywordDto.setUpdateTime(recommendKeyword.getUpdateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
		
		return keywordDto;
	}
	
	public static KeywordDto createKeywordDtoOfSearchMain(RecommendKeyword recommendKeyword) {
		// id, updateTime은 필요 없어서 안 넣어줌
		KeywordDto keywordDto = new KeywordDto();
		keywordDto.setKeywordType(recommendKeyword.getRecommendKeywordType());
		keywordDto.setKeywordName(recommendKeyword.getRecommendKeywordName());
		return keywordDto;
	}
	
	@QueryProjection
	public KeywordDto(String keywordType, String keywordName) {
		this.keywordType = keywordType;
		this.keywordName = keywordName;
	}
}
