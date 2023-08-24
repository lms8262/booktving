package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.ezen.booktving.constant.Role;
import com.ezen.booktving.dto.AuthorBookDto;
import com.ezen.booktving.dto.AuthorBookImgDto;
import com.ezen.booktving.dto.AuthorDtoList;
import com.ezen.booktving.dto.AuthorFormDto;
import com.ezen.booktving.dto.AuthorImgDto;
import com.ezen.booktving.dto.AuthorSearchDto;
import com.ezen.booktving.entity.Author;
import com.ezen.booktving.entity.AuthorBook;
import com.ezen.booktving.entity.AuthorBookImg;
import com.ezen.booktving.entity.AuthorImg;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.AuthorBookImgRepository;
import com.ezen.booktving.repository.AuthorBookRepository;
import com.ezen.booktving.repository.AuthorImgRepository;
import com.ezen.booktving.repository.AuthorRepository;
import com.ezen.booktving.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
	
	private final AuthorRepository authorRepository;
	private final AuthorBookRepository authorBookRepository;
	private final AuthorImgService authorImgService;
	private final MemberRepository memberRepository;
	
	
	//추천작가 목록 페이지
	public Page<AuthorDtoList> getAuthorPage(Pageable pageable){
		
		Page<AuthorDtoList> authorPage = authorRepository.getAuthorPage(pageable);
		
		return authorPage;
	}
	
	//추천작가 관리페이지
	@Transactional(readOnly = true)
	public Page<Author> getAdminAuthorPage(AuthorSearchDto authorSearchDto, Pageable pageable){
		
		Page<Author> authorPage = authorRepository.getAdminAuthorPage(authorSearchDto, pageable);
		
		
		return authorPage;
	}
	
	//추천작가 등록
	public Long saveAuthor(AuthorFormDto authorFormDto, MultipartFile authorImgFile) throws Exception{
	
		//작가등록
		Author author = authorFormDto.createAuthor();
		authorRepository.save(author);
		
		//작가이미지 등록
		AuthorImg authorImg = new AuthorImg();
		authorImg.setAuthor(author);
		authorImgService.saveAuthorImg(authorImg, authorImgFile);		
		
		return author.getId();
	}
	
	//추천작가 도서등록에서 작가정보가져오기
	public List<Author> listAll(){
		List<Author> authorList = authorRepository.findAll(Sort.by(Sort.Direction.ASC, "authorNameKo"));
		
		List<AuthorFormDto> authorFormDtoList = new ArrayList<>();
		
		for(Author author : authorList) {
			
			AuthorFormDto authorFormDto = AuthorFormDto.of(author);
			
			authorFormDtoList.add(authorFormDto);			
		}
		
		return authorList;
	}

	//추천작가 도서등록
	public void saveAuthorBook(AuthorBookDto authorBookDto, MultipartFile authorBookImgFile) throws Exception {
		
		//작가도서 등록
		AuthorBook auhthorBook = authorBookDto.createAuthorBook();
		authorBookRepository.save(auhthorBook);
			
		//작가도서 이미지 등록
		AuthorBookImg authorBookImg = new AuthorBookImg();
		authorBookImg.setAuthorBook(auhthorBook);
		authorImgService.saveAuthorBookImg(authorBookImg, authorBookImgFile);
	}
			
	//현재 접속자가 관리자 인지
	public boolean validateReg(Role role) {
		Member curMember = memberRepository.findByRole(Role.ADMIN);
		
		if(curMember.getRole() != Role.ADMIN) {
			return false;
		}
		return true;
	}
	
	//작가정보 삭제
	@Transactional
	public Author deleteAuthor(Long authorId) {
		
		Author author = authorRepository.findById(authorId).get();
		
		authorRepository.delete(author);
		
		return author;
	}
}
