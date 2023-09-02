package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	List<Question> findByMember(Member member);
}