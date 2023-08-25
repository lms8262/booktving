package com.ezen.booktving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.booktving.dto.QuestionDto;
import com.ezen.booktving.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/question/questionInfo")
	public String questionInfo() {
		
		return "question/questionInfo";
	}
	
	@GetMapping(value = "/question/questionCreate")
	public String questionCreate() {
		
		return "question/questionCreate";
	}
	
	@PostMapping(value = "/question/questionCreate")
	public String recCreate(QuestionDto questionDto) {
		questionService.savePost(questionDto);
		return "question/questionInfo";
	}
	
	@GetMapping(value = "/question/questionList")
	public String questionList() {
		
		return "question/questionList";
	}
}
