package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.ChallengeItemDto;
import com.ezen.booktving.dto.ChallengeNewDto;
import com.ezen.booktving.entity.ChallengeItem;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.ChallengeItemRepository;
import com.ezen.booktving.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ChallengeItemService {
	
	private final MemberRepository memberRepository;
	private final ChallengeItemRepository challengeItemRepository; 
	

	//챌린지 생성하기
	public Long saveChallenge(ChallengeNewDto challengeNewDto, String userId) throws Exception{
		
		Member member = memberRepository.findByUserId(userId);
		
		ChallengeItem challengeItem = ChallengeItem.createChallengeItem(challengeNewDto.getTargetMount(), YesNoStatus.N, YesNoStatus.Y);
		challengeItem.setMember(member);
							
		challengeItemRepository.save(challengeItem);
		
		return challengeItem.getId();
	}
	
	//챌린지 보여주기
	public List<ChallengeItemDto> getChallengeList(String userId){
		
		List<ChallengeItem> challengeItemList = challengeItemRepository.findChallengeItems(userId);
		
		List<ChallengeItemDto> challengeItemDtoList = new ArrayList<>();
		
		for(ChallengeItem challengeItem : challengeItemList) {
			ChallengeItemDto challengeItemDto = new ChallengeItemDto(challengeItem);
			
				challengeItemDtoList.add(challengeItemDto);
			}
						
		return challengeItemDtoList;
	}
	
	/*
	//challengeItem 중 활성화 데이터 가져오기
	public List<ChallengeItemDto> getActioveChallengeList(String userId){
		List<ChallengeItem> activeChallengeItemList = challengeItemRepository.findActiveChallengeItems(userId);
		
		List<ChallengeItemDto> challengeItemDtoList = new ArrayList<>();
		
		for(ChallengeItem challengeItem : activeChallengeItemList) {
			ChallengeItemDto challengeItemDto = new ChallengeItemDto(challengeItem);
			
			challengeItemDtoList.add(challengeItemDto);
		}
		return challengeItemDtoList;
	}
	*/
	
	//challengeItem 중 비활성 데이터 저장하기
	public void deactivateChallenge(Long challengeItemId) {
		ChallengeItem challengeItem = challengeItemRepository.findById(challengeItemId).orElseThrow(EntityNotFoundException::new);
		
		if(challengeItem != null) {
			challengeItem.setIsActive(YesNoStatus.N);
			challengeItemRepository.save(challengeItem);
		}
	}
	
	
	
	//챌린지 성공 데이터 업데이트
	public void updateChallengeItemSuccess(Long challengeItemId) {
		
		ChallengeItem challengeItem = challengeItemRepository.findById(challengeItemId).orElseThrow(EntityNotFoundException::new);
		
		if(challengeItem != null) {
			challengeItem.setSuccess(YesNoStatus.Y);
			challengeItemRepository.save(challengeItem);
		}
	}
	

	
}
