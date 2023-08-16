package com.ezen.booktving.dto;

import java.time.LocalDate;

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
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Book createBook() {
		return modelMapper.map(this, Book.class);
	}
	
	public static BookDto of(Book book) {
		return modelMapper.map(book, BookDto.class);
	}
}