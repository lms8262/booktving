package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.QuestionDto;
import com.ezen.booktving.entity.Question;
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
	
	@Transactional
	public List<QuestionDto> getQuestionList() {
		List<Question> questionList = questionRepo.findAll();
		List<QuestionDto> questionDtoList = new ArrayList<>();
		
		for(Question question : questionList) {
			QuestionDto questionDto = QuestionDto.of(question);
			questionDtoList.add(questionDto);
		}
		
		return questionDtoList;
	}
	
	public QuestionDto getQuestionById(Long id) {
	    Question question = questionRepo.findById(id).orElse(null);
	    if (question != null) {
	        return QuestionDto.of(question);
	    }
	    return null; // 또는 적절한 처리를 수행
	}
}