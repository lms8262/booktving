package com.ezen.booktving.dto;

import com.ezen.booktving.constant.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSearchDto {
	private String searchDateType;
	private Role role;
	private String searchBy;
	private String searchQuery = "";
}
