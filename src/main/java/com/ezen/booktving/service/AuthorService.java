package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.booktving.dto.AuthorBookDto;
import com.ezen.booktving.dto.AuthorBookImgDto;
import com.ezen.booktving.dto.AuthorFormDto;
import com.ezen.booktving.dto.AuthorImgDto;
import com.ezen.booktving.dto.AuthorSearchDto;
import com.ezen.booktving.entity.Author;
import com.ezen.booktving.entity.AuthorBook;
import com.ezen.booktving.entity.AuthorBookImg;
import com.ezen.booktving.entity.AuthorImg;
import com.ezen.booktving.repository.AuthorBookImgRepository;
import com.ezen.booktving.repository.AuthorBookRepository;
import com.ezen.booktving.repository.AuthorImgRepository;
import com.ezen.booktving.repository.AuthorRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
	
	private final AuthorRepository authorRepository;
	private final AuthorBookRepository authorBookRepository;
	private final AuthorImgRepository authorImgRepository;
	private final AuthorBookImgRepository authorBookImgRepository;
	private final AuthorImgService authorImgService;
	
	
	//추천작가 관리페이지
	@Transactional(readOnly = true)
	public Page<Author> getAdminAuthorPage(AuthorSearchDto authorSearchDto, Pageable pageable){
		
		Page<Author> authorPage = authorRepository.getAdminAuthorPage(authorSearchDto, pageable);
		
		return authorPage;
	}
	
	//추천작가 등록 페이지
	public Long saveAuthorFormDto(AuthorFormDto authorFormDto, MultipartFile authorImgFile, MultipartFile authorBookImgFile) throws Exception{
	
		//작가등록
		Author author = authorFormDto.createAuthor();
		authorRepository.save(author);
		
		//작가이미지 등록
		AuthorImg authorImg = new AuthorImg();
		authorImg.setAuthor(author);
		authorImgService.saveAuthorImg(authorImg, authorImgFile);
		
		//작가도서 등록
		AuthorBook auhthorBook = authorFormDto.createAuthorBook();
		authorBookRepository.save(auhthorBook);
		
		//작가도서 이미지 등록
		AuthorBookImg authorBookImg = new AuthorBookImg();
		authorBookImg.setAuthorBook(auhthorBook);
		authorImgService.saveAuthorBookImg(authorBookImg, authorBookImgFile);
		
		return author.getId();
	}
	
	//작가 & 작가도서 정보 가져오기
	@Transactional(readOnly = true)
	public AuthorFormDto getAuthorInfo(Long authorId) {
		
		//작가정보 가져오기
		Author author = authorRepository.findById(authorId)
							.orElseThrow(EntityNotFoundException::new);
		
		AuthorFormDto authorFormDto = AuthorFormDto.of(author);
		
		//작가이미지 정보 가져오기
		AuthorImg authorImg = authorImgRepository.findByAuthorIdOrderByIdAsc(authorId);
		AuthorImgDto authorImgDto = AuthorImgDto.of(authorImg);
        
		//AuthorFormDto 에 작가이미지 정보 넣어주기
		authorFormDto.setAuthorImgDto(authorImgDto);
		
		//작가도서 정보 가져오기
		AuthorBookImg authorBookImg = authorBookImgRepository.findByAuthorBookIdOrderByIdAsc(authorId);
		AuthorBookImgDto authorBookImgDto = AuthorBookImgDto.of(authorBookImg);

		List<AuthorBook> authorBookList = authorBookRepository.findByAuthorIdOrderByIdAsc(authorId);
		
		List<AuthorBookDto> authorBookDtoList = new ArrayList<>();
		for(AuthorBook authorBook :  authorBookList) {
			
			AuthorBookDto authorBookDto = AuthorBookDto.of(authorBook);
			authorBookDto.setAuthorBookImgDto(authorBookImgDto);
			
			authorBookDtoList.add(authorBookDto);			
		}
		
		//AuthorFormDto 에 작가도서 정보 넣어주기
		authorFormDto.setAuthorBookDtoList(authorBookDtoList);
		
		
		return authorFormDto;
	}

	//작가 수정 정보 업데이트 하기
	public Long updateAuthor(AuthorFormDto authorFormDto, MultipartFile authorImgFile) throws Exception {
		
		Author author = authorRepository.findById(authorFormDto.getId())
								.orElseThrow(EntityNotFoundException::new);
		
		author.updateAuthor(authorFormDto);
		
		AuthorImgDto authorImgId = authorFormDto.getAuthorImgId();
		authorImgService.updateAuthorImg(authorImgId.getId(), authorImgFile);
		
		List<Long> authorBookIds = authorFormDto.getAuthorBookIds();
		
		for( int i=0; i<authorBookIds.size(); i++) {
			updateAuthorBook(authorFormDto.getAuthorBookDtoList().get(i), authorImgFile);
		}
		
		return author.getId();
		
	}
	
	public Long updateAuthorBook(AuthorBookDto authorBookDto, MultipartFile authorBookImgFile) throws Exception {
		
		AuthorBook savedAuthorBook = authorBookRepository.findById(authorBookDto.getId())
										.orElseThrow(EntityNotFoundException::new);
		
		String bookName = null;
		String bookSubTitle = null;
		String bookIntrodution = null;
		
		savedAuthorBook.updateAuthorBook(bookName, bookSubTitle, bookIntrodution);
		
		AuthorBookImgDto authorBookImgId = authorBookDto.getAuthorBookImgId();
		authorImgService.updateAuthorBookImg(authorBookImgId.getId(), authorBookImgFile);
		
		return savedAuthorBook.getId();
		
	}
	

}
