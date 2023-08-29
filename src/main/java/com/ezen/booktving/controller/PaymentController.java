package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PaymentController {
	
	@GetMapping(value = "/payment")
	public String payment() {
		return "payment/payment";
	}
}
