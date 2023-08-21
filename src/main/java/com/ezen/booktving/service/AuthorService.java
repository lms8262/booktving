package com.ezen.booktving.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.AuthorFormDto;
import com.ezen.booktving.dto.AuthorSearchDto;
import com.ezen.booktving.entity.Author;
import com.ezen.booktving.repository.AuthorBookRepository;
import com.ezen.booktving.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
	
	private final AuthorRepository authorRepository;
	private final AuthorBookRepository authorBookRepository;
	
	//추천작가 관리페이지
	@Transactional(readOnly = true)
	public Page<Author> getAdminAuthorPage(AuthorSearchDto authorSearchDto, Pageable pageable){
		
		Page<Author> authorPage = authorRepository.getAdminAuthorPage(authorSearchDto, pageable);
		
		return authorPage;
	}
	
	public Long saveAuthor(AuthorFormDto authorFormDto) {
		
		//1.작가등록
		Author author = authorFormDto.creatAuthor();
		authorRepository.save(author);
		
		//2.작가도서등록
	
		return author.getId();
		
	}
	
	
	

}
