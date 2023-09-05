package com.ezen.booktving.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "author_book")
@Getter
@Setter
@ToString
public class AuthorBook extends BaseEntity{
	
	@Id
	@Column(name = "author_book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String bookName;
	
	@Column(nullable = false)
	private String bookSubTitle;
	
	@Column(nullable = false)
	private String bookIntrodution;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;

	public void updateAuthorBook(String bookName, String bookSubTitle, String bookIntrodution) {
		this.bookName = bookName;
		this.bookSubTitle = bookSubTitle;
		this.bookIntrodution = bookIntrodution;
	}
}
