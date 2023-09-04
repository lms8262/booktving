package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.ChallengeItemDto;
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
	public Long saveChallenge(ChallengeItemDto challengeItemDto, String userId) throws Exception{
		
		Member member = memberRepository.findByUserId(userId);
		
		List<ChallengeItem> challengeItemList = new ArrayList<>();
		
		
		
		ChallengeItem challengeItem = ChallengeItem.createChallengeItem(challengeItemDto.getTargetMount(), YesNoStatus.N);
		challengeItem.setMember(member);
		
		challengeItemList.add(challengeItem);
			
		challengeItemRepository.save(challengeItem);
		
		return challengeItem.getId();
	}
	
	//챌린지 보여주기
	public List<ChallengeItemDto> getChallengeList(String userId){
		
		List<ChallengeItem> challengeItems = challengeItemRepository.findChallengeItems(userId);
		
		List<ChallengeItemDto> challengeItemDtos = new ArrayList<>();
		
		for(ChallengeItem challengeItem : challengeItems) {
			ChallengeItemDto challengeItemDto = new ChallengeItemDto(challengeItem);
			
				challengeItemDtos.add(challengeItemDto);
			}
						
		return challengeItemDtos;
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
