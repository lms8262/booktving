package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.dto.QuestionDto;
import com.ezen.booktving.entity.Question;
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
	public String create(Model model) {
		model.addAttribute("questionDto", new QuestionDto());
		return "question/questionCreate";
	}
	
	@PostMapping(value = "/question/questionCreate")
    public String questionCreate(QuestionDto questionDto, Principal principal) {
		String userId = principal.getName();
		questionService.savePost(questionDto, userId);
		return "question/questionInfo";
   }
	
	@GetMapping(value = "/question/questionList")
	public String questionList(Model model) {
		List<QuestionDto> questionDtoList = questionService.getQuestionList();
		model.addAttribute("questionList", questionDtoList);
		return "question/questionList";
	}
	
	@GetMapping(value = "/question/questionDetail/{id}")
	public String questionDetail(@PathVariable Long id, Model model) {
	    QuestionDto questionDto = questionService.getQuestionById(id);
	    model.addAttribute("question", questionDto);
	    return "question/questionDetail";
	}
	
	@GetMapping(value = "/question/questionAnswer")
	public String questionAnswer() {
		
		return "question/questionAnswer";
	}
	
	@DeleteMapping("/question/{id}/delete")
    public @ResponseBody ResponseEntity deleteQuestion(@PathVariable("id") Long id, Principal principal) {
        if (!questionService.validateQue(id, principal.getName())) {
            return new ResponseEntity<String>("문의 삭제 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }

        questionService.deleteQuestion(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

}