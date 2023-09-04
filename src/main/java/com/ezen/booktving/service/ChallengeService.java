package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.ChallengeHistDto;
import com.ezen.booktving.dto.ChallengeItemDto;
import com.ezen.booktving.dto.ChallengeNewDto;
import com.ezen.booktving.entity.Challenge;
import com.ezen.booktving.entity.ChallengeItem;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.ChallengeItemRepository;
import com.ezen.booktving.repository.ChallengeRepository;
import com.ezen.booktving.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ChallengeService {
	
	private final ChallengeRepository challengeRepository;
	private final MemberRepository memberRepository;
	private final ChallengeItemRepository challengeItemRepository; 
	

	//챌린지 생성하기
	public Long saveChallenge(ChallengeNewDto challengeNewDto, String userId) throws Exception{
		
		Member member = memberRepository.findByUserId(userId);
		
		List<ChallengeItem> challengeItemList = new ArrayList<>();
		Challenge challenge = new Challenge();
		challenge.setMember(member);
		
		ChallengeItem challengeItem = ChallengeItem.createChallengeItem(challengeNewDto.getTargetMount(), YesNoStatus.N);
		challengeItem.setChallenge(challenge);
		challengeItemList.add(challengeItem);
		
		challenge.setChallengeItems(challengeItemList);
		
		challengeRepository.save(challenge);
		
		return challenge.getId();
	}
	
	//챌린지 보여주기
	public List<ChallengeHistDto> getChallengeList(String userId){
		
		List<Challenge> challenges = challengeRepository.findChallenges(userId);
		
		List<ChallengeHistDto> challengeHistDtoList = new ArrayList<>();
		
		for(Challenge challenge : challenges) {
			ChallengeHistDto challengeHistDto = new ChallengeHistDto(challenge);
			List<ChallengeItem> challengeItems = challenge.getChallengeItems();
			
			for(ChallengeItem challengeItem : challengeItems) {
				ChallengeItemDto challengeItemDto = new ChallengeItemDto(challengeItem);
				challengeHistDto.addChallengeItemDto(challengeItemDto);
			}
			challengeHistDtoList.add(challengeHistDto);			
		}
		return challengeHistDtoList;
	}
	
	//나의챌린지 목표 달성시 페이지 업데이트하기
	@Transactional
	public void updateChallengeItem(int completedRentBooksCount, int targetMount, long challengeItemId) {
        try {
            ChallengeItem challengeItem = challengeItemRepository.findById(challengeItemId)
            													.orElseThrow(EntityNotFoundException::new);

            if (completedRentBooksCount == targetMount) {
	                challengeItem.setSuccess(YesNoStatus.Y);
            	}
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("챌린지 항목 업데이트 중 오류 발생");
	        }
	    }
	
	//새로운 목표 설정하기
	public void addChallengeItemToUserChallenge(String userId, ChallengeItem challengeItem) {
        Challenge userChallenge = challengeRepository.findUserChallenge(userId);

        if (userChallenge != null) {
            userChallenge.addChallengeItem(challengeItem);
            challengeRepository.save(userChallenge);
        }
    }
	
}
