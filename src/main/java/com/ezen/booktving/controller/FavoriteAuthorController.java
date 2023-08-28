package com.ezen.booktving.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.booktving.service.FavoriteAuthorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mylibrary/favoriteAuthor")
public class FavoriteAuthorController {
	
	private FavoriteAuthorService authorService;
	


}
