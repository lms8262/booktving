package com.ezen.booktving.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeywordFormDto {
	
	private String keywordType;
	
	@NotBlank(message = "공백은 입력이 불가능합니다.")
	private String keywordName;
	
}
