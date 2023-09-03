package com.ezen.booktving.dto;

import com.ezen.booktving.constant.YesNoStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChallengeNewDto {
	
	private Long id;
	
	private int targetMount;
	
	private YesNoStatus success;

	
}
