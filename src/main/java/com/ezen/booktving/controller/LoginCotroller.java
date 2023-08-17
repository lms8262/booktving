package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.dto.LoginFormDto;
import com.ezen.booktving.service.IdService;
import com.ezen.booktving.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginCotroller {

	private final MemberService memberService;
	private final IdService idService;

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

	@RequestMapping(value = "/findId", method = RequestMethod.POST)
	@ResponseBody
	public String finduserId(@RequestParam("memberName") String memberName, @RequestParam("email") String email) {

		String result = idService.finduserId(memberName, email);

		return result;
	}

}
