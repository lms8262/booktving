package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCotroller {
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
	public String membership() {
		return"membership/memberloginForm";
	}
}
