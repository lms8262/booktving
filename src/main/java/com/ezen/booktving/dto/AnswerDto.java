package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Answer;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.Question;

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
	
	private Question question;
	
	private Member member;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static AnswerDto of(Answer answer) {
		AnswerDto answerDto = modelMapper.map(answer, AnswerDto.class);
		return answerDto;
	}
}