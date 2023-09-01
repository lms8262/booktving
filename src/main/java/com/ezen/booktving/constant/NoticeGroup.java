package com.ezen.booktving.constant;

import lombok.Getter;

// notice entity group 필드에 사용
@Getter
public enum NoticeGroup {
	NOTICE("공지"), 
	GUIDE("안내");
	
	private String krName;
	
	NoticeGroup(String krName){
		this.krName = krName;
	}
	
}
