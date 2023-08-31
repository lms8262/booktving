package com.ezen.booktving.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.PaymentFormDto;
import com.ezen.booktving.entity.CommutationTicket;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.MemberCommutation;
import com.ezen.booktving.entity.Payment;
import com.ezen.booktving.repository.CommutationTicketRepository;
import com.ezen.booktving.repository.MemberCommutationRepository;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.repository.PaymentRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	private final MemberRepository memberRepository;
	private final CommutationTicketRepository commutationTicketRepository;
	private final MemberCommutationRepository memberCommutationRepository;
	
	// 결제 성공시 결제 정보 저장 및 회원 이용권 현황 업데이트
	public void savePayment(PaymentFormDto paymentFormDto) {
		Member member = memberRepository.findByUserId(paymentFormDto.getUserId());
		CommutationTicket commutationTicket = commutationTicketRepository.findById(paymentFormDto.getCommutationTicketId()).orElse(null);
		
		if(member == null || commutationTicket == null) {
			throw new EntityNotFoundException();
		}
		
		Payment payment = Payment.builder()
								 .id(paymentFormDto.getPaymentUid())
								 .paymentAmount(paymentFormDto.getPaymentAmount())
								 .paymentName(paymentFormDto.getPaymentName())
								 .impUid(paymentFormDto.getImpUid())
								 .member(member)
								 .commutationTicket(commutationTicket)
								 .build();
		paymentRepository.save(payment);
		
		MemberCommutation memberCommutation = memberCommutationRepository.getMemberCommutationByUserId(paymentFormDto.getUserId());
		
		if(memberCommutation == null) { // 이용권 신규 등록
			MemberCommutation newMemberCommutation = MemberCommutation.builder()
					.endDate(LocalDateTime.now().plusMonths(commutationTicket.getUsePeriod()))
					.member(member)
					.build();
			memberCommutationRepository.save(newMemberCommutation);
			
		} else { // 이용권 존재시 유효기간 체크 후 삭제 후 등록 or 이용기간 연장
			LocalDateTime currentDate = LocalDateTime.now();
			if(memberCommutation.getEndDate().isBefore(currentDate)) { // 이용기간이 지났으면 삭제
				memberCommutationRepository.delete(memberCommutation);
				memberCommutationRepository.flush();
				MemberCommutation newMemberCommutation = MemberCommutation.builder()
						.endDate(LocalDateTime.now().plusMonths(commutationTicket.getUsePeriod()))
						.member(member)
						.build();
				memberCommutationRepository.save(newMemberCommutation);
				
			} else {
				memberCommutation.extendEndDate(commutationTicket.getUsePeriod());
				memberCommutationRepository.save(memberCommutation);
				
			}
		}
		
	}

}
