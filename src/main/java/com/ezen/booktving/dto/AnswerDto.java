package com.ezen.booktving.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AnswerDto {
	private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
}