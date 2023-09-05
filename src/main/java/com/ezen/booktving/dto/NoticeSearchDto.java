package com.ezen.booktving.dto;

import com.ezen.booktving.constant.NoticeGroup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeSearchDto {

	private String searchBy;	
	private NoticeGroup searchNoticeGroup;
	private String searchQuery = "";
	
}
