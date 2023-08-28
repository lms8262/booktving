package com.ezen.booktving.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "new_book_tving")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewBookTving extends BaseEntity{
	
	@Id
	@Column(name = "new_book_tving_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String publisher;
	
	@Column(nullable = false)
	private String imgUrl;
	
	@Column(nullable = false)
	private String link;
	
	@Column(nullable = true)
	private String description;

}
