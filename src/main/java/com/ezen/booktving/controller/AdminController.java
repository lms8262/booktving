package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.booktving.dto.AdminRentHistBookDto;
import com.ezen.booktving.dto.AnswerDto;
import com.ezen.booktving.dto.AuthorBookDto;
import com.ezen.booktving.dto.AuthorFormDto;
import com.ezen.booktving.dto.AuthorSearchDto;
import com.ezen.booktving.dto.BookRegFormDto;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.dto.MemberSearchDto;
import com.ezen.booktving.dto.QuestionDto;
import com.ezen.booktving.entity.Author;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.Question;
import com.ezen.booktving.service.AdminBookRentHistService;
import com.ezen.booktving.service.AdminQuestionService;
import com.ezen.booktving.service.AuthorService;
import com.ezen.booktving.service.BookRegService;
import com.ezen.booktving.service.MemberService;
import com.ezen.booktving.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {

	private final AuthorService authorService;
	private final BookRegService bookRegService;
	private final AdminBookRentHistService adminBookRentHistService;
	private final MemberService memberService;
	private final QuestionService questionService;
	private final AdminQuestionService adminQuestionService;

	// 도서관리 페이지 보여주기
	@GetMapping(value = { "/admin/books", "/admin/books/{page}" })
	public String adminBook(BookSearchDto bookSearchDto, @PathVariable("page") Optional<Integer> page, Model model) {

		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);

		Page<Book> books = bookRegService.getAdminBookPage(bookSearchDto, pageable);

		model.addAttribute("books", books);
		model.addAttribute("bookSearchDto", bookSearchDto);
		model.addAttribute("maxPage", 5);

		return "admin/adminBook";
	}

	// 도서등록 페이지 보여주기
	@GetMapping(value = "/admin/bookReg")
	public String adminBoomReg(Model model) {

		model.addAttribute("bookRegFormDto", new BookRegFormDto());
		return "admin/adminBookReg";
	}

	@PostMapping(value = "/admin/bookReg")
	// 도서등록, 도서이미지 등록(insert)
	public String bookInsert(@Valid BookRegFormDto bookRegFormDto, BindingResult bindingResult, Model model,
			@RequestParam("BookImgFile") List<MultipartFile> bookImgFileList) {

		if (bindingResult.hasErrors()) {
			return "admin/adminBookReg";
		}

		// 도서 등록전에 첫번째 이미지가 있는지 없는지 검사(첫번째 이미지는 필수 입력값)
		if (bookImgFileList.get(0).isEmpty()) {
			model.addAttribute("errorMessage", "첫번째 이미지는 필수 등록 하셔야 합니다.");
			return "admin/adminBookReg";
		}

		try {
			bookRegService.saveBook(bookRegFormDto, bookImgFileList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "도서등록 도중에 에러가 발생했습니다.");
			return "admin/adminBookReg";
		}

		return "redirect:/";
	}

	// 도서수정 페이지 보여주기
	@GetMapping(value = "/admin/book/{bookId}")
	public String adminBookModify(@PathVariable("bookId") Long bookId, Model model) {

		try {
			BookRegFormDto bookRegFormDto = bookRegService.getBookDtl(bookId);
			model.addAttribute("bookRegFormDto", bookRegFormDto);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "상품정보를 가져올때 에러가 발생했습니다.");

			// 에러 발생시 비어있는 객체를 넘겨준다.
			model.addAttribute("bookRegFormDto", new BookRegFormDto());
			return "admin/adminBookReg";
		}

		return "admin/adminBookModify";
	}

	// 도서 수정(update)
	@PostMapping(value = "/admin/book/{bookId}")
	public String adminBookUpdate(@Valid BookRegFormDto bookRegFormDto, Model model, BindingResult bindingResult,
			@RequestParam("bookImgFile") List<MultipartFile> bookimgFileList) {

		if (bindingResult.hasErrors()) {
			return "admin/adminBookReg";
		}

		// 첫번째 이미지가 있는지 검사
		if (bookimgFileList.get(0).isEmpty() && bookRegFormDto.getId() == null) {
			model.addAttribute("errorMessage", "첫번째 도서 이미지는 필수 입니다.");
			return "admin/adminBookReg";
		}

		try {
			bookRegService.updateBook(bookRegFormDto, bookimgFileList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "도서 정보 수정 중 에러가 발생 했습니다.");
			return "admin/adminBookReg";
		}

		return "redirect:/";
	}

	// 도서 상세 페이지 삭제
	@DeleteMapping("/admin/book/{bookId}/delete")
	public @ResponseBody ResponseEntity deleteBooks(@PathVariable("bookId") Long bookId, Principal principal) {

		bookRegService.deleteBooks(bookId);

		return new ResponseEntity<Long>(bookId, HttpStatus.OK);
	}

	// 회원관리 페이지 보여주기
	@GetMapping(value = "/admin/member")
	public String adminMemberMng(MemberSearchDto membersearchDto,
			@PathVariable("page") @RequestParam(name = "page", required = false, defaultValue = "0") int page,
			Model model) {
		Pageable pageable = PageRequest.of(page, 3);
		Page<Member> members = memberService.getAdminMemberPage(membersearchDto, pageable);
		model.addAttribute("members", members);
		model.addAttribute("membersearchDto", membersearchDto);
		model.addAttribute("maxPage", 5);
		return "admin/adminMemberMng";
	}

	// 회원 관리 삭제
	@DeleteMapping(value = "/admin/member/{memberId}/delete")
	public @ResponseBody ResponseEntity deleteMember(@PathVariable("memberId") Long memberId) {
		memberService.deleteMember(memberId);
		return new ResponseEntity<Long>(memberId, HttpStatus.OK);
	}

	// 회원정보 상세페이지 보여주기 //value 경로는 개발하면서 변경. {memberId}
	@GetMapping(value = "/admin/member/")
	public String adminMemberDetail() {

		return "admin/adminMemberDetail";
	}

	// 대출관리 페이지 보여주기
	@GetMapping(value = { "/admin/rents", "/admin/rents/{page}" })
	public String adminRent(BookSearchDto bookSearchDto, @PathVariable("page") Optional<Integer> page, Model model) {

		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);

		// 서비스 호출
		Page<AdminRentHistBookDto> rentBooks = adminBookRentHistService.getAdminRentHistPage(bookSearchDto, pageable);

		model.addAttribute("rentBooks", rentBooks);
		model.addAttribute("bookSearchDto", bookSearchDto);
		model.addAttribute("maxPage", 5);

		return "admin/adminRent";
	}

	// 도서 상세 페이지 삭제
	@DeleteMapping("/admin/rents/{rentBookId}/delete")
	public @ResponseBody ResponseEntity deleteAdminRentBook(@PathVariable("rentBookId") Long rentBookId,
			Principal principal) {

		adminBookRentHistService.deleteAdminRentBook(rentBookId);

		return new ResponseEntity<Long>(rentBookId, HttpStatus.OK);
	}

	// 키워드관리 페이지 보여주기
	@GetMapping(value = "/admin/keyword")
	public String adminKeyword() {

		return "admin/adminKeyword";
	}

	// 추천작가 관리 페이지 보여주기
	@GetMapping(value = { "/admin/author", "/admin/author/{page}" })
	public String adminAuthor(AuthorSearchDto authorSearchDto, @PathVariable("page") Optional<Integer> page,
			Model model) {

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

	// 추천작가 등록 페이지 보여주기
	@GetMapping(value = "/admin/authorReg")
	public String adminAuthorReg(Model model) {
		model.addAttribute("authorFormDto", new AuthorFormDto());

		return "admin/adminAuthorReg";
	}

	// 추천작가 등록하기
	@PostMapping(value = "/admin/authorReg")
	public String authorNew(@Valid AuthorFormDto authorFormDto, BindingResult bindingResult, Model model,
			@RequestParam("authorImgFile") MultipartFile authorImgFile) {

		if (bindingResult.hasErrors()) {
			return "admin/adminAuthorReg";
		}

		if (authorImgFile == null) {
			model.addAttribute("errorMessage", "이미지 등록은 필수입니다.");
			return "admin/adminAuthorReg";
		}

		try {
			authorService.saveAuthor(authorFormDto, authorImgFile);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "작가 등록 중 에러가 발생했습니다.");
			return "admin/adminAuthorReg";
		}

		return "redirect:/admin/author";
	}

	// 작가정보 삭제
	@DeleteMapping("/admin/author/delete")
	public String deleteAuthor(@RequestParam(name = "chBoxs", required = false) Long[] chBoxs) {

		// 작가정보 삭제
		if (chBoxs != null && chBoxs.length > 0) {
			for (Long authorId : chBoxs) {
				authorService.deleteAuthor(authorId);
			}
		}
		return "redirect:/admin/author";
	}

	// 추천작가 도서등록 페이지 보여주기
	@GetMapping(value = "/admin/authorBookReg/{authorId}")
	public String adminAuthorBookReg(Model model, @PathVariable("authorId") Long authorId) {

		List<Author> listAuthor = authorService.listAll();

		model.addAttribute("authorBookDto", new AuthorBookDto());
		model.addAttribute("listAuthor", listAuthor);

		return "admin/adminAuthorBookReg";
	}

	// 추천작가 도서 등록하기
	@PostMapping(value = "/admin/authorBookReg")
	public String authorBookNew(@Valid AuthorBookDto authorBookDto, BindingResult bindingResult, Model model,
			@RequestParam("authorBookImgFile") MultipartFile authorBookImgFile) {

		if (bindingResult.hasErrors()) {
			return "admin/adminAuthorBookReg";
		}

		try {
			authorService.saveAuthorBook(authorBookDto, authorBookImgFile);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "작가도서 등록 중 에러가 발생했습니다.");
			return "admin/adminAuthorBookReg";
		}
		return "redirect:/admin/author";
	}

	// 문의관리 페이지 보여주기
		@GetMapping(value = "/admin/question")
		public String adminQuestion(QuestionDto questionDto, @PathVariable("page") Optional<Integer> page, Model model) {
			Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
			List<QuestionDto> questionDtoList = questionService.getQuestionList();
			model.addAttribute("questionList", questionDtoList);
			return "admin/adminQuestion";
		}

		// 문의답변 페이지 보여주기
		@GetMapping(value = "/admin/answer/{id}")
		public String adminAnswer(@PathVariable Long id, Model model) {
			QuestionDto questionDto = questionService.getQuestionById(id);
			model.addAttribute("question", questionDto);
			return "admin/adminAnswer";
		}

		// 문의 답변 작성 및 저장
		@PostMapping(value = "/admin/answer")
		public String saveAdminAnswer(AnswerDto answerDto, Long questionId, Principal principal) {

			System.out.println(answerDto);
			System.out.println(questionId);
			System.out.println(principal);

			adminQuestionService.saveAnswer(answerDto, questionId, principal.getName());
			return "redirect:/admin/question";
//			return null;
		}

		// 문의삭제
		@DeleteMapping("/admin/question/{id}/delete")
		public @ResponseBody ResponseEntity deleteAdminQuestion(@PathVariable("id") Long id, Principal principal) {
			adminQuestionService.deleteAdminQuestion(id);
			return new ResponseEntity<Long>(id, HttpStatus.OK);
		}

	// 공지관리 페이지 보여주기
	@GetMapping(value = "/admin/notice")
	public String adminNotice() {

		return "admin/adminNotice";
	}

	// 공지사항 등록 페이지 보여주기
	@GetMapping(value = "/admin/noticeReg")
	public String adminNoticeReg() {

		return "admin/adminNoticeReg";
	}

	// 공지사항 수정 페이지 보여주기
	@GetMapping(value = "/admin/noticeModify")
	public String adminNoticeModify() {

		return "admin/adminNoticeModify";
	}

}