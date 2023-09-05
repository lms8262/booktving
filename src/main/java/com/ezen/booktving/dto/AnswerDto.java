package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Answer;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AnswerDto {
	private Long id;
	
	@NotBlank
	private String content;
	
	public static AnswerDto of(Answer answer, ModelMapper modelMapper) {
		AnswerDto answerDto = modelMapper.map(answer, AnswerDto.class);
		return answerDto;
	}
}