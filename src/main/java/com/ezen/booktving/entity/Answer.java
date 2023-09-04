package com.ezen.booktving.entity;

import com.ezen.booktving.constant.QuestionStatus;
import com.ezen.booktving.dto.AnswerDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "answer")
@Getter
@Setter
@ToString
public class Answer extends BaseEntity {
	
	@Id
	@Column(name = "answer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "longtext", nullable = false)
	private String content;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", unique = true, nullable = false)
	private Question question;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	public static Answer createAnswer(AnswerDto answerDto, Question question, Member answerMember) {
		
		question.setQuestionStatus(QuestionStatus.COMPLETE);
		
		Answer answer = new Answer();
		answer.setContent(answerDto.getContent());
		answer.setQuestion(question);
		answer.setMember(answerMember);
		
		return answer;
	}
}