package com.ezen.booktving.controller;

import org.aspectj.weaver.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.booktving.dto.LoginFormDto;
import com.ezen.booktving.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginCotroller {
	
	private final MemberService memberService;
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
		
		if(bindingRestult.hasErrors()) {
			return "membership/memberloginForm";
		}
		Member member = Member.createMember(loginFormDto,passwordEncoder);
		memberService.saveMember(member);
	}
}
