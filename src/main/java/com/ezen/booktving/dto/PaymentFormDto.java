package com.ezen.booktving.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentFormDto {
	
	private String paymentUid;
	
	private Integer paymentAmount;
	
	private String paymentName;
	
	private String userId;
	
	private String impUid;
	
	private Long commutationTicketId;
	
}
