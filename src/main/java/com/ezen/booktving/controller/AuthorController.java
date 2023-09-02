package com.ezen.booktving.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezen.booktving.dto.AuthorDtoList;
import com.ezen.booktving.dto.AuthorFormDto;
import com.ezen.booktving.service.AuthorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthorController {
	
	private final AuthorService authorService;

	//작가목록 페이지 보여주기
	@GetMapping(value = "/author/list")
	public String authorList(Model model, Optional<Integer> page) {
	
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 20);
		Page<AuthorDtoList> authors = authorService.getAuthorPage(pageable);
		
		model.addAttribute("authors", authors);
		
		
		return "author/authorList";
	}
	
	//작가 상세페이지 보여주기
	@GetMapping(value = "/author/detail/{authorId}")
	public String authotDetail(Model model, @PathVariable("authorId") Long authorId) {
			
		AuthorFormDto authorDto = authorService.getAuthorDtl(authorId);
		
		model.addAttribute("author", authorDto);
		model.addAttribute("authorBooks", authorDto.getAuthorBookDtoList());
				
		return "author/authorDetail";
	}
	
}
