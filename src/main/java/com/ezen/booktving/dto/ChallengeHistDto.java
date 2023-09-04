package com.ezen.booktving.dto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ezen.booktving.entity.Challenge;
import com.ezen.booktving.entity.ChallengeItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChallengeHistDto {
	
	private Long challengeId;
	
	private String challengeDate;
	
	private List<ChallengeItemDto> challengeItemDtoList = new ArrayList<>();

	public ChallengeHistDto(Challenge challenge) {
		this.challengeId = challenge.getId();
		this.challengeDate = challenge.getRegTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public void addChallengeItemDto(ChallengeItemDto challengeItemDto ) {
		this.challengeItemDtoList.add(challengeItemDto);
	}
}
