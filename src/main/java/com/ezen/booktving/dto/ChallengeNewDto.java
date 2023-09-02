package com.ezen.booktving.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Challenge;
import com.ezen.booktving.entity.ChallengeItem;
import com.ezen.booktving.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChallengeNewDto {
	
	private Long id;
	
	private Member member;
	
	private List<ChallengeItem> challengeItemList = new ArrayList<>();
	
	public Challenge createChallenge(ModelMapper modelMapper) {
		return modelMapper.map(this, Challenge.class);
	}
	
	public static ChallengeNewDto of(Challenge challenge, ModelMapper modelMapper) {
		return modelMapper.map(challenge, ChallengeNewDto.class);
	}
	
	
}
