package com.ezen.booktving.dto;

import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.RentBook;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminRentHistBookDto {
	
	private Long id; //대여 아이디
	
	private Long BookId; //도서 아이디
	
	private String rentDate; //대여날짜
	
	private String bookName; //도서명
	
	private String userId; //회원ID
	
	private String userName; //회원 이름
	
	public AdminRentHistBookDto(RentBook rentBook) {
		this.id = rentBook.getId();
		this.BookId = rentBook.getBook().getId();
		this.rentDate = rentBook.getRentDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.bookName = rentBook.getBook().getBookName();
		this.userId = rentBook.getMember().getUserId();
		this.userName = rentBook.getMember().getMemberName();
	}
	
	public static AdminRentHistBookDto of(RentBook rentBook, ModelMapper modelMapper) {
		return modelMapper.map(rentBook, AdminRentHistBookDto.class);
	}
	
}
