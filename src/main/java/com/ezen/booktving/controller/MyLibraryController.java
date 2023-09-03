package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.booktving.dto.ChallengeHistDto;
import com.ezen.booktving.dto.ChallengeNewDto;
import com.ezen.booktving.dto.FavoriteBookDtoList;
import com.ezen.booktving.dto.MyLibraryRentBookInfoDto;
import com.ezen.booktving.dto.MyLibraryRentBookListDto;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.RentBook;

import com.ezen.booktving.service.ChallengeService;
import com.ezen.booktving.service.FavoriteBookService;
import com.ezen.booktving.service.MemberService;
import com.ezen.booktving.service.MyLibraryRentBookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyLibraryController {
	
	private final MyLibraryRentBookService myLibraryRentBookService;
	private final FavoriteBookService favoriteBookService;
	private final MemberService memberService;
	private final ChallengeService challengeService;
	
	
	
	//나의서재 메인화면
	@GetMapping(value = "/myLibrary")
	public String myLibrary(Optional<Integer> page, Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		if(userDetails != null) {
			
			Member user = memberService.listAll(userDetails.getUsername());
			model.addAttribute("user", user);
			
			Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);

			//bookcase
			//isEmpty
			List<RentBook> rentBookList = myLibraryRentBookService.listAll(userDetails.getUsername());
			model.addAttribute("rentBookList", rentBookList);
			//not isEmpty
			Page<MyLibraryRentBookListDto> rentBooks = myLibraryRentBookService.getMyLibraryRentBookList(userDetails.getUsername(), pageable);
			model.addAttribute("rentBooks", rentBooks);
			
			//favoriteBook
			//isEmpty
			List<FavoriteBook> favoriteBookList = favoriteBookService.getFavoriteListAll(userDetails.getUsername());
			model.addAttribute("favoriteBookList", favoriteBookList);
			//not isEmpty
			Page<FavoriteBookDtoList> favoriteBooks = favoriteBookService.getFavoriteBookList(userDetails.getUsername(), pageable);
			model.addAttribute("favoriteBooks", favoriteBooks);
			
						
			return "myLibrary/myLibraryMain";
		} else {
			
			return "redirect:/login";
		}
	}
	
	//나의 서재 대여도서 리스트
	@GetMapping(value= {"/myLibrary/rentList", "/myLibrary/rentList/{page}"})
	public String myLibraryRentList(@PathVariable("page") Optional<Integer> page, Principal principal, Model model) {
		
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 8);
		
		//2. 서비스 호출
		Page<MyLibraryRentBookListDto> myLibraryRentBookListDtoList = myLibraryRentBookService.getMyLibraryRentBookList(principal.getName(), pageable);
		
		//3. 서비스에서 가져온 값들을 view단에 model을 이용해 전송
		model.addAttribute("rentBooks", myLibraryRentBookListDtoList);
		model.addAttribute("maxPage", 5);
		
		return "myLibrary/myLibraryRentBookList";
	}
	
	//나의 서재 대여도서 상세페이지 	
	@GetMapping(value = "/myLibrary/rentbookinfo/{rentBookId}")
	public String myLibraryRentBookInfo(Model model,@AuthenticationPrincipal UserDetails userDetails, @PathVariable("rentBookId") Long rentBookId) {
		
		MyLibraryRentBookInfoDto rentBookInfoDto = myLibraryRentBookService.getMyLibraryRentBookInfo(rentBookId);
		model.addAttribute("rentBookDto", rentBookInfoDto);
		
		return "myLibrary/myLibraryRentBookInfo";
	}
	
	//나의서재 - 대여도서 -독서완료 등록하기
	@PostMapping(value = "/myLibrary/rentbookinfo/Complete")
	public String rentBookComplete(@RequestParam("rentBookId") Long rentBookId) {
		
		myLibraryRentBookService.rentBookComplete(rentBookId);
		return "redirect:/myLibrary/rentbookinfo/\" + rentBookId;";
	}
	
	//나의서재 - 대여도서 -리뷰등록
	@PostMapping(value = "/myLibrary/rentbookinfo/addReview")
    public String addReview(@RequestParam("reviewText") String reviewText, @RequestParam("rentBookId") Long rentBookId) {

		myLibraryRentBookService.addReview(rentBookId, reviewText);
        return "redirect:/myLibrary/rentbookinfo/" + rentBookId;
    }
	
	//나의서재 - 대여도서 - 리뷰삭제
    @PostMapping(value = "/myLibrary/rentbookinfo/deleteReview")
    public String deleteReview(@RequestParam("rentBookId") Long rentBookId) {
    	
        myLibraryRentBookService.deleteReview(rentBookId);
        return "redirect:/myLibrary/rentbookinfo/" + rentBookId;
    }
	
	//나의서재 - 대여도서 - 한문장 등록
	@PostMapping(value = "/myLibrary/rentbookinfo/addSentence")
	public String addSentence(@RequestParam("sentence") String sentence, @RequestParam("rentBookId") Long rentBookId) {
		
		myLibraryRentBookService.addSentence(rentBookId, sentence);
		return "redirect:/myLibrary/rentbookinfo/" + rentBookId;
	}	
	
	//나의서재 - 대여도서 - 한문장 삭제
	@PostMapping(value = "/myLibrary/rentbookinfo/deleteSentence")
    public String deleteSentence(@RequestParam("rentBookId") Long rentBookId) {
		
        myLibraryRentBookService.deleteSentence(rentBookId);
        return "redirect:/myLibrary/rentbookinfo/" + rentBookId;
    }

	//나의챌린지 페이지
	@GetMapping(value = "/myLibrary/myChallenge")
	public String myChallenge(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		Member user = memberService.listAll(userDetails.getUsername());
		model.addAttribute("user", user);
		
		List<ChallengeHistDto> challengeHistDtoList = challengeService.getChallengeList(userDetails.getUsername());
		model.addAttribute("challengeHistDtos", challengeHistDtoList);
		
		//List<RentBookDto> rentBookDtoList = myLibraryRentBookService.getMyRentBookList(userDetails.getUsername());
		//model.addAttribute("rentBookDtoList", rentBookDtoList);
		
		long completedRentBooksCount = myLibraryRentBookService.getCountOfCompletedRentBooks(userDetails.getUsername());
	    model.addAttribute("completedRentBooksCount", completedRentBooksCount);
		
		return "myLibrary/myChallenge";
	}
	
	
	//나의챌린지 목표 달성시 페이지 업데이트하기
	@PostMapping(value = "/updateChallengeItem")
	public ResponseEntity<String> updateChallengeItem(@RequestParam("completedRentBooksCount") int completedRentBooksCount,
									  @RequestParam("targetMount") int targetMount,
									  @RequestParam("challengeItemId") long challengeItemId) {
		
		try {
	        challengeService.updateChallengeItem(completedRentBooksCount, targetMount, challengeItemId);
	        return ResponseEntity.ok("데이터베이스 업데이트 성공");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("데이터베이스 업데이트 실패");
	    }
	}
	
	
	//나의챌린지 생성 페이지
	@GetMapping(value = "/myLibrary/myChallenge/new")
	public String myChallengeNewPage(Model model, @AuthenticationPrincipal UserDetails userDetails, @Valid ChallengeNewDto challengeNewDto, BindingResult bindingResult ) {
		
		Member user = memberService.listAll(userDetails.getUsername());
		model.addAttribute("user", user);
		
		return "myLibrary/myChallengeNew";
	}
	
	//나의챌린지 생성하기
	@PostMapping(value = "/myLibrary/myChallenge/new")
	public String myChallengeNew(@RequestBody @Valid ChallengeNewDto challengeNewDto, 
					BindingResult bindingResult, Model model, Principal principal) {
		
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			for(FieldError fieldError : fieldErrors) {
				sb.append(fieldError.getDefaultMessage());  //에러메세지를 합친다.
			}
			return "redirect:/myLibrary/myChallenge/new";
		}
		
		String userId = principal.getName();
		Long challengeId;
		
		try {
			challengeId = challengeService.saveChallenge(challengeNewDto, userId);
		} catch (Exception e) {
			return "redirect:/myLibrary/myChallenge/new";
		}
		return "redirect:/myLibrary/myChallenge/" + challengeId;
	}

}
