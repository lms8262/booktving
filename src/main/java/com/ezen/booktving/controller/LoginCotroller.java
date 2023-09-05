package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.booktving.auth.OAuth2UserInfo;
import com.ezen.booktving.auth.PrincipalDetails;
import com.ezen.booktving.dto.MemberFormDto;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.service.MemberService;
import com.ezen.booktving.service.RamdomPasswordService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginCotroller {

	private final MemberService memberService;
	private final MemberRepository memberRepository;
	private final RamdomPasswordService randomPassword;
	private final PasswordEncoder passwordEncoder;

	// 로그인 화면
	@GetMapping(value = "/login")
	public String loginList() {
		return "login/login";
	}

	// 로그인 실패했을때
	@GetMapping(value = "/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 입력해주세요");
		return "login/login";

	}

//회원가입
	@GetMapping(value = "/login/new")
	public String membership(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());
		return "membership/memberloginForm";
	}

	@PostMapping(value = "/login/new")
	public String membership(@Valid MemberFormDto memberFormDto, BindingResult bindingRestult, Model model) {

		if (bindingRestult.hasErrors()) {
			return "membership/memberloginForm";
		}
		try {
			memberService.createMember(memberFormDto, passwordEncoder);
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "membership/memberloginForm";
		}
		return "login/login";
	}

	// 소셜 로그인 회원가입 페이지
	@GetMapping(value = "/login/sns")
	public String snsship(Authentication authentication, Model model) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		OAuth2UserInfo oAuth2UserInfo = principal.getOAuth2UserInfo();

		MemberFormDto memberFormDto = new MemberFormDto();
		memberFormDto.setMemberName(oAuth2UserInfo.getName());
		memberFormDto.setProvider(oAuth2UserInfo.getProvider());
		memberFormDto.setProviderId(oAuth2UserInfo.getProviderId());
		memberFormDto.setPassword(principal.getPassword());

		model.addAttribute("memberFormDto", memberFormDto);
		return "login/joinForm";
	}

	@PostMapping(value = "/login/sns/new")
	public String snsNew(@Valid MemberFormDto memberFormDto, BindingResult bindingRestult, Model model,
			RedirectAttributes redirectAttributes) {

		if (bindingRestult.hasErrors()) {
			return "login/joinForm";
		}
		try {
			memberService.createMember(memberFormDto, passwordEncoder);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
			return "redirect:/login/sns";
		}
		return "redirect:/";
	}

	// 아이디 찾기
	@GetMapping("/findid")
	public String showFindIdForm() {
		return "login/findIdForm"; // Return the template for the "Find ID" form
	}

	@PostMapping("/findid")
	public String findId(@RequestParam("memberName") String memberName, @RequestParam("email") String email,
			Model model) {

		Member member = memberRepository.findByMemberNameAndEmail(memberName, email);

		if (member != null) {
			model.addAttribute("userId", member.getUserId());
		} else {
			model.addAttribute("userIdNotFound", true);
		}

		return "login/findIdResult"; // Return the template to display the search result
	}

	// 비밀 번호 찾기
	@GetMapping(value = "/findpw")
	public String search_ps(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());

		return "login/findPwForm";
	}

	// 비밀번호 찾고 난수생성기로 랜덤비밀번호 생성
	@PostMapping("/findpw")
	@ResponseBody
	public HashMap<String, String> memberps(@RequestBody Map<String, Object> psdata, Principal principal) {

		String email = (String) psdata.get("email");
		String userId = (String) psdata.get("userId");

		HashMap<String, String> msg = new HashMap<>();
		Member member = memberRepository.findByUserIdAndEmail(userId, email);
		/*
		 * String pass = randomPassword.passwordFind(email, null); // pass 암호화된 비밀번호
		 * String ramdomps = randomPassword.getRamdomPassword(12);
		 * 
		 * // ramdomps 를 view에 출력 String password =
		 * randomPassword.updatePassword(ramdomps, email, passwordEncoder);
		 * 
		 * randomPassword.sendEmail(email, "새로운 비밀번호", "새로운 비밀번호: " + ramdomps);
		 * 
		 * String asd = "이메일로 임시 비밀번호가 발송되었습니다."; msg.put("message", asd);
		 */
		if (member != null) {
			String ramdomps = randomPassword.getRamdomPassword(12);
			String encodedRandomPassword = passwordEncoder.encode(ramdomps);

			member.setPassword(encodedRandomPassword);
			memberRepository.save(member);

			randomPassword.sendEmail(email, "새로운 비밀번호", "새로운 비밀번호: " + ramdomps);

			String asd = "이메일로 임시 비밀번호가 발송되었습니다.";
			msg.put("message", asd);
		} else {
			String errorMsg = "해당하는 사용자가 없습니다.";
			msg.put("message", errorMsg);
		}

		return msg;
	}

//회원정보 수정페이지
	@GetMapping(value = "/login/update")
	public String getupdateDtl(Model model, Principal principal) {
		try {
			MemberFormDto memberFormDto = memberService.getUpdateDtl(principal.getName());
			model.addAttribute("memberFormDto", memberFormDto);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "고객정보를 가져올때 에러가 발생했습니다.");
			model.addAttribute("memberFormDto", new MemberFormDto());
			return "membership/privacy";
		}
		return "membership/privacy";
	};

//회원 수정
	@PostMapping(value = "/login/update")
	public String memberUpdate(@Valid MemberFormDto memberFormDto, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "membership/privacy";
		}
		try {
			memberService.updateMember1(memberFormDto, passwordEncoder);
		} catch (Exception e) {
			model.addAttribute("errorMessage", "고객정보를 가져올때 에러가 발생했습니다.");
			e.printStackTrace();
			// TODO: handle exception
		}
		return "redirect:/";
	}

//회원탈퇴
	@DeleteMapping(value = "/login/{userId}/delete")
	public ResponseEntity<String> deleteMember2(@PathVariable("userId") String userId, Principal principal) {
		try {
			memberService.deleteMember2(userId);
			return new ResponseEntity<>("탈퇴했습니다.", HttpStatus.OK);
		}

		catch (Exception e) {
			return new ResponseEntity<>("Error deleting member: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}