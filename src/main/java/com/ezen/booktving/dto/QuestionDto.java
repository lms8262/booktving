package com.ezen.booktving.dto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.QuestionStatus;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.Question;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class QuestionDto {
	private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private Member member;
	
	private LocalDate questionDate;
	
	private QuestionStatus questionStatus;
	
	private static ModelMapper modelMapper = new ModelMapper();
		
	public Question createQuestion() {
		return modelMapper.map(this, Question.class);
	}
	
	public static QuestionDto of(Question question) {
		return modelMapper.map(question, QuestionDto.class);
	}
}