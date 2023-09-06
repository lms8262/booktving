package com.ezen.booktving.dto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.QuestionStatus;
import com.ezen.booktving.entity.Question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminQuestionDto {
	
	private Long id;
	
	private String title;
	
	private String content;
	
	private String userId;
	
	private LocalDate questionDate;
	
	private QuestionStatus questionStatus;
	
	public AdminQuestionDto(Question question) {
		this.id = question.getId();
		this.title = question.getTitle();
		this.content = question.getContent();
		this.userId = question.getMember().getUserId();
		this.questionDate = question.getQuestionDate();
		this.questionStatus = question.getQuestionStatus();
	}
	
	public Question createQuestion(ModelMapper modelMapper) {
		return modelMapper.map(this, Question.class);
	}
	
	public static AdminQuestionDto of(Question question, ModelMapper modelMapper) {
		return modelMapper.map(question, AdminQuestionDto.class);
	}
}
