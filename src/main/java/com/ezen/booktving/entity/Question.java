package com.ezen.booktving.entity;

import java.time.LocalDate;

import com.ezen.booktving.constant.QuestionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "question")
@Getter
@Setter
@ToString
public class Question extends BaseEntity {
	
	@Id
	@Column(name = "quesion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "longtext", nullable = false)
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	private LocalDate questionDate;

	@Enumerated(EnumType.STRING)
	private QuestionStatus questionStatus;
	
	public static Question createQuestion(Member member) {
		Question question = new Question();
		question.setMember(member);
		
		question.setQuestionStatus(QuestionStatus.WAIT);
		question.setQuestionDate(LocalDate.now());
		
		return question;
	
}
}
