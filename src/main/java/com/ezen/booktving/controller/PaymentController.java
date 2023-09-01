package com.ezen.booktving.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.dto.CommutationTicketDto;
import com.ezen.booktving.dto.PaymentFormDto;
import com.ezen.booktving.service.CommutationService;
import com.ezen.booktving.service.PaymentService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PaymentController {
	
	private final CommutationService commutationService; 
	private final PaymentService paymentService;
	
	// 결제 선택창
	@GetMapping(value = "/payment")
	public String payment(Model model) {
		List<CommutationTicketDto> commutationTicketList = commutationService.getCommutationTicketList();
		
		model.addAttribute("commutationTicketList", commutationTicketList);
		return "payment/payment";
	}
	
	// 결제 완료시 넘어갈 페이지
	@GetMapping(value = "/payment/result")
	public String paymentResult() {
		return "payment/paymentResult";
	}
	
	// 결제 검증
	@PostMapping(value = "/payment/validate/{imp_uid}")
	@ResponseBody
	public IamportResponse<Payment> paymentValidateByImpUid(@PathVariable("imp_uid") String imp_uid) throws IamportResponseException, IOException {
		IamportClient iamportClient = new IamportClient("4645627078045677", "0Z94Zi5KoCFCoIkYpm5bhBSOcdW4jYLyJDhF8qNaZDBIzufW5ODxT91D4HIl0A0dmH4Mr16UcjNYwsPS");
		return iamportClient.paymentByImpUid(imp_uid);
	}
	
	// 결제 성공시 실행
	@PostMapping(value = "/payment/success")
	@ResponseBody
	public ResponseEntity paymentSuccess(@RequestBody PaymentFormDto paymentFormDto) {
		try {
			paymentService.savePayment(paymentFormDto);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
