package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.AdminQuestionDto;
import com.ezen.booktving.entity.Question;
import com.ezen.booktving.repository.AdminQuestionRepository;
import com.ezen.booktving.repository.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminQuestionService {
	private final AdminQuestionRepository adminQuestionRepo;
	private final QuestionRepository questionRepo;
	
	@Transactional(readOnly = true)
	public AdminQuestionDto getAdminQuestion(Long id) {
		Question question = adminQuestionRepo.findById(id)
						.orElseThrow(EntityNotFoundException::new);
		AdminQuestionDto adminQuestionDto = AdminQuestionDto.of(question);
		return adminQuestionDto;
	}
	
	@Transactional(readOnly = true)
	public Page<AdminQuestionDto> getAdminQuestionPage(Pageable pageable) {
		Page<Question> questionPage = adminQuestionRepo.getQuestion(pageable);
		List<Question> questionList = questionPage.getContent();
		
		List<AdminQuestionDto> questions = new ArrayList<>();
		for(Question question : questionList) {
			AdminQuestionDto adminQuestionDto = new AdminQuestionDto(question);
			questions.add(adminQuestionDto);
		}
		
		return new PageImpl<>(questions, pageable, questionPage.getTotalElements());
	}
	
	public void deleteAdminQuestion(Long id) {
		Question question = questionRepo.findById(id)
							.orElseThrow(EntityNotFoundException::new);
		questionRepo.delete(question);
	}
}
