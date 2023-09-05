package com.ezen.booktving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.auth.PrincipalDetails;
import com.ezen.booktving.dto.ChallengeItemDto;
import com.ezen.booktving.dto.ChallengeNewDto;
import com.ezen.booktving.dto.FavoriteBookDto;
import com.ezen.booktving.dto.FavoriteBookDtoList;
import com.ezen.booktving.dto.MyLibraryRentBookInfoDto;
import com.ezen.booktving.dto.MyLibraryRentBookListDto;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.RentBook;
import com.ezen.booktving.service.ChallengeItemService;
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
	private final ChallengeItemService challengeItemService;
	
	//나의서재 메인화면
	@GetMapping(value = "/myLibrary")
	public String myLibrary(Optional<Integer> page, Model model, Authentication authentication) {
		if(authentication == null) {
			return "redirect:/login";
		}
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		
		String memberName = memberService.getLoginMemberName(userId);
		model.addAttribute("memberName", memberName);
		
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);

		//bookcase
		//isEmpty
		List<RentBook> rentBookList = myLibraryRentBookService.listAll(userId);
		model.addAttribute("rentBookList", rentBookList);
		//not isEmpty
		Page<MyLibraryRentBookListDto> rentBooks = myLibraryRentBookService.getMyLibraryRentBookList(userId, pageable);
		model.addAttribute("rentBooks", rentBooks);
		
		//favoriteBook
		//isEmpty
		List<FavoriteBook> favoriteBookList = favoriteBookService.getFavoriteListAll(userId);
		model.addAttribute("favoriteBookList", favoriteBookList);
		//not isEmpty
		Page<FavoriteBookDtoList> favoriteBooks = favoriteBookService.getFavoriteBookList(userId, pageable);
		model.addAttribute("favoriteBooks", favoriteBooks);
					
		return "myLibrary/myLibraryMain";
		
	}
	
	//나의 서재 대여도서 리스트
	@GetMapping(value= {"/myLibrary/rentList", "/myLibrary/rentList/{page}"})
	public String myLibraryRentList(@PathVariable("page") Optional<Integer> page, Authentication authentication, Model model) {
		if(authentication == null) {
			return "redirect:/login";
		}
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 8);
		
		//2. 서비스 호출
		Page<MyLibraryRentBookListDto> myLibraryRentBookListDtoList = myLibraryRentBookService.getMyLibraryRentBookList(userId, pageable);
		
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
		return "redirect:/myLibrary/rentbookinfo/" + rentBookId;
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
	public String myChallenge(Model model, Authentication authentication) {
		if(authentication == null) {
			return "redirect:/login";
		}
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		
		String memberName = memberService.getLoginMemberName(userId);
		model.addAttribute("memberName", memberName);
		
		List<ChallengeItemDto> challengeItemDtoList = challengeItemService.getChallengeList(userId);
		model.addAttribute("challengeItemDtoList", challengeItemDtoList);
		
		long completedRentBooksCount = myLibraryRentBookService.getCountOfCompletedRentBooks(userId);
		model.addAttribute("completedRentBooksCount", completedRentBooksCount);
		
		return "myLibrary/myChallenge";
		
	}
	
	//나의챌린지 목표 달성시 페이지 업데이트하기
	@PostMapping(value = "/updateChallengeItem/{challengeItemId}")
	@ResponseBody
	public ResponseEntity updateChallengeItem(@PathVariable("challengeItemId") Long challengeItemId) {
		
		try {
			challengeItemService.updateChallengeItemSuccess(challengeItemId);
			return new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//나의챌린지-아이템 비활성화 시키기
	@PostMapping(value = "/deactivateChallenge/{challengeItemId}")
	@ResponseBody
	public ResponseEntity deactivateChallenge(@PathVariable("challengeItemId") Long challengeItemId) {
		
		try {
			challengeItemService.deactivateChallenge(challengeItemId);
			return new ResponseEntity<>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//나의챌린지 생성 페이지
	@GetMapping(value = "/myLibrary/myChallenge/new")
	public String myChallengeNewPage(Model model, Authentication authentication, 
									@Valid ChallengeNewDto challengeNewDto, BindingResult bindingResult) {
		if(authentication == null) {
			return "redirect:/login";
		}
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		
		String memberName = memberService.getLoginMemberName(userId);
		model.addAttribute("memberName", memberName);
		
		return "myLibrary/myChallengeNew";
	}
	
	//나의챌린지 생성하기
	@PostMapping(value = "/myLibrary/myChallenge/new")
	public @ResponseBody ResponseEntity myChallengeNew(@RequestBody @Valid ChallengeNewDto challengeNewDto, 
					BindingResult bindingResult, Authentication authentication) {
		if(authentication == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			
			for(FieldError fieldError : fieldErrors) {
				sb.append(fieldError.getDefaultMessage());  //에러메세지를 합친다.
			}
			return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
		}
		
		try {
			challengeItemService.saveChallenge(challengeNewDto, userId);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 찜 목록
	@GetMapping(value = "/myLibrary/favoritebook")
	public String myFavorite(Model model, Authentication authentication) {
		if(authentication == null) {
			return "redirect:/login";
		}
		
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		String userId = principalDetails.getUserId();

		// 사용자의 찜한 도서 목록 가져오기
		List<FavoriteBookDto> favoriteBookDtos = favoriteBookService.getFavoriteBooksByMember(userId);

		model.addAttribute("favoriteBooks", favoriteBookDtos);

		return "book/myFavorite";
	}

	// 찜 삭제
	@DeleteMapping("/myLibrary/favoritebook/remove/{id}")
	public @ResponseBody ResponseEntity removeFavoriteBook(@PathVariable("id") Long id) {
		favoriteBookService.removeFavoriteBook(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

}
