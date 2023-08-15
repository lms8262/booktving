package com.ezen.booktving.entity;

import java.time.LocalDate;

import com.ezen.booktving.dto.BookRegFormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book")
@Getter
@Setter
@ToString
public class Book extends BaseTimeEntity {
	
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String bookName;
	
	@Column(nullable = false, unique = true)
	private String isbn;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String publisher;
	
	@Column(nullable = false)
	private Integer page;
	
	@Column(nullable = false)
	private LocalDate publicationDate;
	
	@Column(columnDefinition = "text", nullable = false)
	private String bookIntroduction;
	
	@Column(columnDefinition = "text", nullable = false)
	private String contents;
	
	@Column(nullable = false)
	private String category;
	
	
	//book 엔티티 수정
	public void updateBook(BookRegFormDto bookRegFormDto) {
		this.bookName = bookRegFormDto.getBookName();
		this.isbn = bookRegFormDto.getIsbn();
		this.author = bookRegFormDto.getAuthor();
		this.publisher = bookRegFormDto.getPublisher();
		this.page = bookRegFormDto.getPage();
		this.publicationDate = bookRegFormDto.getPublicationDate();
		this.bookIntroduction = bookRegFormDto.getBookIntroduction();
		this.contents = bookRegFormDto.getContents();
		this.category = bookRegFormDto.getCategory();
	}
}
