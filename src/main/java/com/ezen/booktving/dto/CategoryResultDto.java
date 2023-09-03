package com.ezen.booktving.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryResultDto {
	
	private Integer categoryId;
	
	private int totalItems;
	
	private int currentPage;
	
	private int itemsPerPage;
	
	private boolean last;
	
	private List<SearchBookDto> items;
}
