package com.ezen.booktving.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginCotroller {
	// 로그인 화면
		@GetMapping(value = "/login")
		public String memberList() {
			return "login/login";
		}
}
