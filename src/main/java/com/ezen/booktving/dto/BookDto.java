package com.ezen.booktving.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Book;

import lombok.*;

@Getter
@Setter
public class BookDto {
	
	private Long id;
	
	private String bookName;
	
	private String isbn;
	
	private String author;
	
	private String publisher;
	
	private Integer page;
	
	private LocalDate publicationDate;
	
	private String bookIntroduction;
	
	private String contents;
	
	private String category;
	
	private String authorInfo;
	
	private List<BookImgDto> bookImgDtoList = new ArrayList<>();
	
	private List<BookReviewDto> bookReviewDtoList = new ArrayList<>();
	
	public Book createBook(ModelMapper modelMapper) {
		Book book = modelMapper.map(this, Book.class);
		book.setAuthorInfo("");
		return book;
	}
	
	public static BookDto of(Book book, ModelMapper modelMapper) {
		return modelMapper.map(book, BookDto.class);
	}
}
