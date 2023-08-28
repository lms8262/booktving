package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}