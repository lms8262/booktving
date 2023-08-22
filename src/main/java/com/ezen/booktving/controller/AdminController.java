package com.ezen.booktving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.booktving.dto.AuthorFormDto;
import com.ezen.booktving.dto.AuthorSearchDto;
import com.ezen.booktving.entity.Author;
import com.ezen.booktving.service.AuthorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	private final AuthorService authorService;

	//도서관리 페이지 보여주기 
	@GetMapping(value = "/admin/book")
	public String adminBook() {
		
		return "admin/adminBook";
	}
	
	//도서등록 페이지 보여주기
	@GetMapping(value = "/admin/bookReg")
	public String adminBoomReg() {
		
		return "admin/adminBookReg";
	}
	
	//도서수정 페이지 보여주기
	@GetMapping(value = "/admin/bookModify")
	public String adminBookModify() {
		
		return "admin/adminBookModify";
	}
	
	//회원관리 페이지 보여주기 
	@GetMapping(value = "/admin/member")
	public String adminMemberMng() {
		
		return "admin/adminMemberMng";
	}	
	
	//회원정보 상세페이지 보여주기    //value 경로는 개발하면서 변경. {memberId} 
	@GetMapping(value = "/admin/member/")
	public String adminMemberDetail() {
		
		return "admin/adminMemberDetail";
	}
	
	//대출관리 페이지 보여주기
	@GetMapping(value = "/admin/rent")
	public String adminRent() {
		
		return "admin/adminRent";
	}
	
	//키워드관리 페이지 보여주기
	@GetMapping(value = "/admin/keyword")
	public String adminKeyword() {
		
		return "admin/adminKeyword";
	}
	
	//추천작가 관리 페이지 보여주기
	@GetMapping(value = {"/admin/author", "/admin/author/{page}"})
	public String adminAuthor(AuthorSearchDto authorSearchDto, @PathVariable("page") Optional<Integer> page, Model model) {
		
		try {
			Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
			Page<Author> authors = authorService.getAdminAuthorPage(authorSearchDto, pageable);

			model.addAttribute("authors", authors);
			model.addAttribute("authorSearchDto", authorSearchDto);
			model.addAttribute("maxPage", 5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "admin/adminAuthor";
	}
	
	//추천작가 등록 페이지 보여주기
	@GetMapping(value = "/admin/authorReg")
	public String adminAuthorReg(Model model) {
		model.addAttribute("authorFormDto", new AuthorFormDto());
		
		return "admin/adminAuthorReg";
	}
	
	//추천작가 등록하기
	@PostMapping(value = "/admin/authorReg")
	public String authorNew(@Valid AuthorFormDto authorFormDto, BindingResult bindingResult, Model model, 
			@RequestParam("authorImgFile") MultipartFile authorImgFile, @RequestParam("authorBookImgFile") MultipartFile authorBookImgFile) {
		
		if(bindingResult.hasErrors()) {
			return "admin/adminAuthorReg";
		}
		
		if(authorImgFile == null) {
			model.addAttribute("errorMessage", "이미지 등록은 필수입니다.");
			return "admin/adminAuthorReg";
		}
		
		try {
			authorService.saveAuthorFormDto(authorFormDto, authorImgFile, authorBookImgFile);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "작가 등록 중 에러가 발생했습니다.");
			return "admin/adminAuthorReg";
		}
		
		return "redirect:/";
	}
		
	//추천작가 수정 페이지 보여주기
	@GetMapping(value = "/admin/authorModify/{authorId}")
	public String adminAuthorModify(@PathVariable("authorId") Long authorId, Model model) {
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "데이터를 가져올 때 에러가 발생했습니다.");
			
			model.addAttribute("authorFormDto", new AuthorFormDto());
			return "admin/adminAuthorReg";
		}
		
		return "admin/adminAuthorModify";
	}
	
	//추천작가 수정등록하기
	@PostMapping(value = "/admin/authorModify/{authorId}")
	public String authorUpdate(@Valid AuthorFormDto authorFormDto, Model model, BindingResult bindingResult, 
				@RequestParam("authorImgFile") MultipartFile authorImgFile, @RequestParam("authorBookImgFile") MultipartFile authorBookImgFile) {
		
		if(bindingResult.hasErrors()) {
			return "admin/adminAuthorReg";
		}
		
		if(authorImgFile == null && authorBookImgFile == null && authorFormDto.getId() == null ) {
			model.addAttribute("errorMessage", "이미지는 필수 등록입니다.");
			return "admin/adminAuthorReg";
		}
		
		try {
			authorService.updateAuthor(authorFormDto, authorImgFile);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "작가 정보 수정 중 에러가 발생했습니다.");
			return "admin/adminAuthorReg";
		}
		return "redirect:/";
	}
	
	
	//문의관리 페이지 보여주기
	@GetMapping(value = "/admin/question")
	public String adminQuestion() {
		
		return "admin/adminQuestion";
	}
	
	//문의답변 페이지 보여주기
	@GetMapping(value = "/admin/answer")
	public String adminAnswer() {
		
		return "admin/adminAnswer";
	}
	  
	//공지관리 페이지 보여주기
	@GetMapping(value = "/admin/notice")
	public String adminNotice() {
		
		return "admin/adminNotice";
	}
	
	//공지사항 등록 페이지 보여주기
	@GetMapping(value = "/admin/noticeReg")
	public String adminNoticeReg() {
		
		return "admin/adminNoticeReg";
	}
	
	//공지사항 수정 페이지 보여주기
	@GetMapping(value = "/admin/noticeModify")
	public String adminNoticeModify() {
		
		return "admin/adminNoticeModify";
	}
	
}
