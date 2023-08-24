package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QuestionController {

	@RequestMapping(value = "/question/questionInfo")
	public String questionInfo() {
		
		return "/question/questionInfo";
	}
}
