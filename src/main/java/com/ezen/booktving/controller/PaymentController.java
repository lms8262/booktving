package com.ezen.booktving.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.dto.CommutationTicketDto;
import com.ezen.booktving.service.CommutationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PaymentController {
	
	private final CommutationService commutationService; 
	
	@GetMapping(value = "/payment")
	public String payment(Model model) {
		List<CommutationTicketDto> commutationTicketList = commutationService.getCommutationTicketList();
		
		model.addAttribute("commutationTicketList", commutationTicketList);
		return "payment/payment";
	}
	
	@GetMapping(value = "/payment/result")
	public String paymentResult() {
		return "payment/paymentResult";
	}
	
	@PostMapping(value = "/payment/success")
	@ResponseBody
	public ResponseEntity payment(String paymentUid, Integer paymentAmount, String paymentName, String userId, String impUid) {
		System.out.println(paymentUid);
		System.out.println(paymentAmount);
		System.out.println(paymentName);
		System.out.println(userId);
		System.out.println(impUid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
