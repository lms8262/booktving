package com.ezen.booktving.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.MemberCommutationDto;
import com.ezen.booktving.repository.MemberCommutationRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommutationService {
	
	private final MemberCommutationRepository memberCommutationRepository;
	
	@Transactional(readOnly = true)
	public MemberCommutationDto getMemberCommutationInfo(String userId) {
		return memberCommutationRepository.getMemberCommutationInfo(userId);
	}
	
}
