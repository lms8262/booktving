package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Answer;
import com.ezen.booktving.entity.Question;

public interface AnswerRepository extends JpaRepository<Answer, Long>{
	List<Answer> findByQuestion(Question question);
	Answer findByQuestionId(Long questionId);
}
