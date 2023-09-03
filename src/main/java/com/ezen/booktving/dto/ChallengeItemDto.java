package com.ezen.booktving.dto;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.ChallengeItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChallengeItemDto {

	private Integer targetMount;
	
	private YesNoStatus success;
	
	public ChallengeItemDto(ChallengeItem challengeItem) {
		this.targetMount = challengeItem.getTargetMount();
		this.success = challengeItem.getSuccess();
	}
	
}
