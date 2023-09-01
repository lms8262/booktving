package com.ezen.booktving.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommutationTicketDto {
	
	private Long commutationTicketId;
	
	private String commutationName;
	
	private Integer price;
	
}
