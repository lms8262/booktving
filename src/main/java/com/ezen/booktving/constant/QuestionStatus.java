package com.ezen.booktving.constant;

import lombok.Getter;

@Getter
public enum QuestionStatus {
	WAIT("답변 대기중"),
	COMPLETE("답변완료");
	
	private String krName;
	
	QuestionStatus(String krName) {
		this.krName = krName;
	}
}
