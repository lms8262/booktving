package com.ezen.booktving.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Question;

public interface AdminQuestionRepository extends JpaRepository<Question, Long>, AdminQuestionRepositoryCustom{

	Optional<Question> findById(Long id);
	
}
