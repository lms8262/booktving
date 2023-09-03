package com.ezen.booktving.dto;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.RentBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentBookDto {

	private YesNoStatus completeYn;
	
	public RentBookDto(RentBook rentBook) {
		this.completeYn = rentBook.getCompleteYn();
	}
	
}
