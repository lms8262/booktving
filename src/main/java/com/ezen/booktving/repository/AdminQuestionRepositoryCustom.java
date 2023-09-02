package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.entity.Question;

public interface AdminQuestionRepositoryCustom {

	Page<Question> getQuestion(Pageable pageable);
}
