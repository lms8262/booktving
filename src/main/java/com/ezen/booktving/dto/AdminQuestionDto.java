package com.ezen.booktving.dto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.QuestionStatus;
import com.ezen.booktving.entity.Member;
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
	
	private Member member;
	
	private LocalDate questionDate;
	
	private QuestionStatus questionStatus;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public AdminQuestionDto(Question question) {
		this.id = question.getId();
		this.title = question.getTitle();
		this.content = question.getContent();
		this.member = question.getMember();
		this.questionDate = question.getQuestionDate();
	}
	
	public Question createQuestion() {
		return modelMapper.map(this, Question.class);
	}
	
	public static AdminQuestionDto of(Question question) {
		return modelMapper.map(question, AdminQuestionDto.class);
	}
}
