package com.ezen.booktving.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.CommutationTicketDto;
import com.ezen.booktving.dto.MemberCommutationDto;
import com.ezen.booktving.entity.CommutationTicket;
import com.ezen.booktving.entity.MemberCommutation;
import com.ezen.booktving.repository.CommutationTicketRepository;
import com.ezen.booktving.repository.MemberCommutationRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommutationService {
	
	private final MemberCommutationRepository memberCommutationRepository;
	private final CommutationTicketRepository commutationTicketRepository;
	
	// 이용권 관리 페이지에 보여줄 회원의 이용권 현황
	public MemberCommutationDto getMemberCommutationInfo(String userId) {
		MemberCommutation memberCommutation = memberCommutationRepository.getMemberCommutationByUserId(userId);
		LocalDateTime currentDate = LocalDateTime.now();
		if(memberCommutation != null) {			
			if(memberCommutation.getEndDate().isBefore(currentDate)) { // 이용기간이 지났으면 삭제
				memberCommutationRepository.delete(memberCommutation);
				memberCommutationRepository.flush();
			}
		}
		return memberCommutationRepository.getMemberCommutationInfo(userId);
	}
	
	// 대여가능 상태를 확인(이용권을 이용중인지 아닌지 확인)
	public boolean isExistsMemberCommutation(String userId) {
		MemberCommutation memberCommutation = memberCommutationRepository.getMemberCommutationByUserId(userId);
		LocalDateTime currentDate = LocalDateTime.now();
		if(memberCommutation != null) {	
			if(memberCommutation.getEndDate().isBefore(currentDate)) { // 이용기간이 지났으면 삭제
				memberCommutationRepository.delete(memberCommutation);
				memberCommutationRepository.flush();
				return false;
			}
			return true; // 이용기간이 남았을때
		}
		return false; // 이용중이지 않을때
	}
	
	// 이용권 구매 페이지에 보여줄 이용권 목록
	@Transactional(readOnly = true)
	public List<CommutationTicketDto> getCommutationTicketList() {
		List<CommutationTicket> commutationTicketList = commutationTicketRepository.findAll();
		
		List<CommutationTicketDto> commutationTicketDtoList = new ArrayList<>();
		if(commutationTicketList.size() == 0) {
			return commutationTicketDtoList;
		}
		
		for(CommutationTicket commutationTicket : commutationTicketList) {
			CommutationTicketDto commutationTicketDto = CommutationTicketDto.builder()
														.commutationTicketId(commutationTicket.getId())
														.commutationName(commutationTicket.getCommutationName())
														.price(commutationTicket.getPrice())
														.build();
			commutationTicketDtoList.add(commutationTicketDto);
		}
		
		return commutationTicketDtoList;
	}
}
