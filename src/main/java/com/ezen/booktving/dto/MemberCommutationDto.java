package com.ezen.booktving.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberCommutationDto {
	
	private String startDate;
	
	private String endDate;
	
	@QueryProjection
	public MemberCommutationDto(LocalDateTime regTime, LocalDateTime endDate) {
		this.startDate = regTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
		this.endDate = endDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
	}
	
}
