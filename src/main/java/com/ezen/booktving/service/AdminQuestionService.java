package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.QuestionStatus;
import com.ezen.booktving.dto.AdminQuestionDto;
import com.ezen.booktving.dto.AnswerDto;
import com.ezen.booktving.dto.QuestionDto;
import com.ezen.booktving.entity.Answer;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.Question;
import com.ezen.booktving.repository.AdminQuestionRepository;
import com.ezen.booktving.repository.AnswerRepository;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.repository.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminQuestionService {
	private final AdminQuestionRepository adminQuestionRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final MemberRepository memberRepository;
	
	@Transactional(readOnly = true)
	public AdminQuestionDto getAdminQuestion(Long id) {
		Question question = adminQuestionRepository.findById(id)
						.orElseThrow(EntityNotFoundException::new);
		AdminQuestionDto adminQuestionDto = AdminQuestionDto.of(question);
		return adminQuestionDto;
	}
	
	@Transactional(readOnly = true)
	public Page<AdminQuestionDto> getAdminQuestionPage(Pageable pageable) {
		Page<Question> questionPage = adminQuestionRepository.getQuestion(pageable);
		List<Question> questionList = questionPage.getContent();
		
		List<AdminQuestionDto> questions = new ArrayList<>();
		for(Question question : questionList) {
			AdminQuestionDto adminQuestionDto = new AdminQuestionDto(question);
			questions.add(adminQuestionDto);
		}
		
		return new PageImpl<>(questions, pageable, questionPage.getTotalElements());
	}
	
	@Transactional
	public String saveAnswer(AnswerDto answerDto, Long questionId, String username) {
	    Question question = questionRepository.findById(questionId)
	            .orElseThrow(EntityNotFoundException::new);
	    
	    Member member = memberRepository.findByUserId(username);
	    
	    if(member == null) {
	    	throw new EntityNotFoundException();
	    }

	    Answer answer = Answer.createAnswer(answerDto, question, member);
	    answer.setQuestion(question);

	    answerRepository.save(answer);
        
        return answer.getContent();
    }
	
	public AnswerDto getAnswerById(Long id) {
		Answer answer = answerRepository.findById(id).orElse(null);
		if (answer != null) {
			return AnswerDto.of(answer);
		}
		return null;
	}

		public void deleteAdminQuestion(Long id) {
		Question question = questionRepository.findById(id)
							.orElseThrow(EntityNotFoundException::new);
		questionRepository.delete(question);
	}
	
}