package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.dto.QuestionDto;
import com.ezen.booktving.entity.Answer;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.Question;
import com.ezen.booktving.repository.AnswerRepository;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.repository.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
	
	private final ModelMapper modelMapper;
	private final QuestionRepository questionRepository;
	private final MemberRepository memberRepository;
	private final AnswerRepository answerRepository;

	@Transactional
	public String savePost(QuestionDto questionDto, String userId) {
		Member member = memberRepository.findByUserId(userId);
		Question question = Question.createQuestion(questionDto, member);
		questionRepository.save(question);
		
		return question.getTitle();
	}

	@Transactional
	public List<QuestionDto> getQuestionList() {
		List<Question> questionList = questionRepository.findAll();
		List<QuestionDto> questionDtoList = new ArrayList<>();

		for (Question question : questionList) {
			QuestionDto questionDto = QuestionDto.of(question, modelMapper);
			questionDtoList.add(questionDto);
		}

		return questionDtoList;
	}

	public QuestionDto getQuestionById(Long id) {
		Question question = questionRepository.findById(id).orElse(null);
		if (question != null) {
			return QuestionDto.of(question, modelMapper);
		}
		return null; 
	}
	
	public Answer getAnswerById(Long questionId) {
		 return answerRepository.findByQuestionId(questionId);
	}
		

	@Transactional(readOnly = true)
	public boolean validateQue(Long id, String userId) {
		Member curMember = memberRepository.findByUserId(userId);
		Question question = questionRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		Member savedMember = question.getMember();

		if (!StringUtils.equals(curMember.getId(), savedMember.getId())) {
			return false;
		}

		return true;
	}

	public void deleteQuestion(Long id) {
		Question question = questionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		
		Answer answer = answerRepository.findByQuestionId(question.getId());
		
		answerRepository.delete(answer);
		questionRepository.delete(question);
	}
}