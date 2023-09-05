package com.ezen.booktving.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRegFormDto {
	private Long id;
	
	@NotBlank(message = "도서명은 필수 입력 값 입니다.")
	private String bookName;
	
	@NotBlank(message = "isbn은 필수 입력 값 입니다.")
	private String isbn;
	
	@NotBlank(message = "작가명은 필수 입력 값 입니다.")
	private String author;
	
	@NotBlank(message = "출판사명은 필수 입력 값 입니다.")
	private String publisher;
	
	@NotNull(message = "페이지수는 필수 입력 값 입니다.")
	private Integer page;
	
	@NotNull(message = "출판일은 필수 입력 값 입니다.")
	private LocalDate publicationDate;
	
	@NotBlank(message = "책소개는 필수 입력 값 입니다.")
	private String bookIntroduction;
	
	@NotBlank(message = "목차는 필수 입력 값 입니다.")
	private String contents;
	
	@NotBlank(message = "카테고리는 필수 선택 사항 입니다.")
	private String category;
	
	@NotBlank(message = "카테고리는 필수 선택 사항 입니다.")
	private String itemId;
	
	//도서 이미지 정보를 저장
	private List<BookImgDto> bookImgDtoList = new ArrayList<>();
	
	//도서 이미지 아이디들을 저장 -> 수정시에 이미지 아이디들을 담아둘 용도
	private List<Long> bookImgIds = new ArrayList<>();
	
	//dto -> entity로 바꿈
	public Book createBook(ModelMapper modelMapper) {
		return modelMapper.map(this, Book.class);
	}
	
	//entity -> dto로 바꿈
	public static BookRegFormDto of(Book book, ModelMapper modelMapper) {
		return modelMapper.map(book, BookRegFormDto.class);
	}

}
