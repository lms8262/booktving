package com.ezen.booktving.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.booktving.auth.PrincipalDetails;
import com.ezen.booktving.dto.QuestionDto;
import com.ezen.booktving.entity.Answer;
import com.ezen.booktving.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QuestionController {
	
	private final QuestionService questionService;

	@GetMapping(value = "/question/questionInfo")
	public String questionInfo() {
		return "question/questionInfo";
	}
	
	// 문의 작성 페이지
	@GetMapping(value = "/question/questionCreate")
	public String create(Model model) {
		model.addAttribute("questionDto", new QuestionDto());
		return "question/questionCreate";
	}
	
	// 문의 작성
	@PostMapping(value = "/question/questionCreate")
	public String questionCreate(QuestionDto questionDto, Authentication authentication) {
		if(authentication == null) {
			return "redirect:/login";
		}
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();

		questionService.savePost(questionDto, userId);
		return "question/questionInfo";
	}
	
	// 내 문의 목록
	@GetMapping(value = "/question/questionList")
	public String questionList(Model model) {
		List<QuestionDto> questionDtoList = questionService.getQuestionList();
		model.addAttribute("questionList", questionDtoList);
		return "question/questionList";
	}
	
	// 문의 상세 페이지
	@GetMapping(value = "/question/questionDetail/{id}")
	public String questionDetail(@PathVariable Long id, Model model) {
		QuestionDto questionDto = questionService.getQuestionById(id);
		Answer answer = questionService.getAnswerById(questionDto.getId());
		model.addAttribute("question", questionDto);
		model.addAttribute("answer", answer);
		return "question/questionDetail";
	}
	
	// 문의 답변 상세 페이지
	@GetMapping(value = "/question/questionAnswer/{id}")
	public String questionAnswer(@PathVariable Long id, Model model) {
		QuestionDto questionDto = questionService.getQuestionById(id);
		
		model.addAttribute("question", questionDto);
		return "question/questionAnswer";
	}

}