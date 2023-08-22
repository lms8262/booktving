package com.ezen.booktving.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.AuthorBookDto;
import com.ezen.booktving.dto.AuthorDto;
import com.ezen.booktving.dto.AuthorFormDto;
import com.ezen.booktving.dto.AuthorSearchDto;
import com.ezen.booktving.entity.Author;
import com.ezen.booktving.entity.AuthorBook;
import com.ezen.booktving.repository.AuthorBookRepository;
import com.ezen.booktving.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
	
	private final AuthorRepository authorRepository;
	private final AuthorBookRepository authorBookRepository;
	private final FileService fileService;
	
	
	//추천작가 관리페이지
	@Transactional(readOnly = true)
	public Page<Author> getAdminAuthorPage(AuthorSearchDto authorSearchDto, Pageable pageable){
		
		Page<Author> authorPage = authorRepository.getAdminAuthorPage(authorSearchDto, pageable);
		
		return authorPage;
	}
	
	//추천작가 등록 페이지
	public void saveAuthorFormDto(AuthorFormDto authorFormDto) {
		try {
			
		
		AuthorDto authorDto = authorFormDto.getAuthorDto();
		
		Author author = new Author();
			author.setAuthorNameKo(authorDto.getAuthorNameKo());
			author.setAuthorNameEg(authorDto.getAuthorNameEg());
			author.setTitle(authorDto.getTitle());
			author.setAuthorIntroduction(authorDto.getAuthorIntroduction());
			author.setImgName(fileService.authorUploadFile(authorDto.getAuthorImgFile(), "authorImg"));
			author.setOriImgName(authorDto.getOriImgName());
			author.setImgUrl(authorDto.getImgUrl());		
			authorRepository.save(author);
		
		List<AuthorBookDto> authorBookDtoList = authorFormDto.getAuthorBookDtoList();
		for(AuthorBookDto authorBookDto : authorBookDtoList) {
			
			AuthorBook authorBook = new AuthorBook();
				authorBook.setBookName(authorBook.getBookName());
				authorBook.setBookSubTitle(authorBookDto.getBookSubTitle());
				authorBook.setBookIntrodution(authorBookDto.getBookIntrodution());
				authorBook.setImgName(fileService.authorUploadFile(authorBookDto.getAuthorBookImgFile(), "authorBookImg"));
				authorBook.setOriImgName(authorBookDto.getOriImgName());
				authorBook.setImgUrl(authorBookDto.getImgUrl());
				authorBook.setAuthor(author);
				authorBookRepository.save(authorBook);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
