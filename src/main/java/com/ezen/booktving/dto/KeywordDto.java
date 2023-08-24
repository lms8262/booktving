package com.ezen.booktving.dto;

import java.time.format.DateTimeFormatter;

import com.ezen.booktving.entity.RecommendKeyword;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
