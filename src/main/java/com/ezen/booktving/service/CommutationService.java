package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.CommutationTicketDto;
import com.ezen.booktving.dto.MemberCommutationDto;
import com.ezen.booktving.entity.CommutationTicket;
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
	@Transactional(readOnly = true)
	public MemberCommutationDto getMemberCommutationInfo(String userId) {
		return memberCommutationRepository.getMemberCommutationInfo(userId);
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
