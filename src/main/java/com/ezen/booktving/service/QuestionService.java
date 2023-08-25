package com.ezen.booktving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.QuestionDto;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepo;
	private MemberRepository memberRepo;
	
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	@Transactional
	public String savePost(QuestionDto questionDto) {
		return questionRepo.save(questionDto.createQuestion()).getTitle();
	}
}
