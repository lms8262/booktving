package com.ezen.booktving.entity;

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
public class AuthorBook{
	
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
	
	@Column(nullable = false, unique = true)
	private String imgName;
	
	@Column(nullable = false)
	private String oriImgName;
	
	@Column(nullable = false)
	private String imgUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;
	
}
