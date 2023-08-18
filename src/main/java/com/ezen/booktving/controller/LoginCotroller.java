package com.ezen.booktving.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.dto.LoginFormDto;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.service.IdService;
import com.ezen.booktving.service.MemberService;
import com.ezen.booktving.service.RamdomPassword;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginCotroller {
	
	private final MemberService memberService;
	private final IdService idService;
	private final MemberRepository memberRepository;
	private final RamdomPassword randomPassword;
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

	@GetMapping(value = "/login/new")
	public String membership(Model model) {
		model.addAttribute("loginFormDto", new LoginFormDto());
		return "membership/memberloginForm";
	}

	@PostMapping(value = "/login/new")
	public String membership(@Valid LoginFormDto loginFormDto, BindingResult bindingRestult, Model model) {

		if (bindingRestult.hasErrors()) {
			return "membership/memberloginForm";
		}
		try {
			memberService.createMember(loginFormDto);
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "membership/memberloginForm";
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
		model.addAttribute("loginFormDto", new LoginFormDto());

		return "login/findPwForm";
	}

	// 비밀번호 찾고 난수생성기로 랜덤비밀번호 생성
	@PostMapping("/findpw")
	@ResponseBody
	public HashMap<String, String> memberps(@RequestBody Map<String, Object> psdata, Principal principal) {
		String email = (String) psdata.get("email");
		
		
		HashMap<String, String> msg = new HashMap<>();
		
		String pass = randomPassword.passwordFind(email);
		// pass 암호화된 비밀번호
		String ramdomps = randomPassword.getRamdomPassword(12);

		// ramdomps 를 view에 출력
		String password = randomPassword.updatePassword(ramdomps, email, passwordEncoder);
		
		randomPassword.sendEmail(email, "새로운 비밀번호", "새로운 비밀번호: " + ramdomps);
		
		String asd = "이메일로 임시 비밀번호가 발송되었습니다.";
		msg.put("message", asd);

		return msg;
	}

}
