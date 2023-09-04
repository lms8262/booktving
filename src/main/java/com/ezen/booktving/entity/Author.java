package com.ezen.booktving.entity;

import com.ezen.booktving.dto.AuthorFormDto;

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
@Table(name = "author")
@Getter
@Setter
@ToString
public class Author  extends BaseEntity{
	
	@Id
	@Column(name = "author_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String authorNameKo;
	
	@Column(nullable = false)
	private String authorNameEg;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "text", nullable = false)
	private String authorIntroduction;
	
	public void updateAuthor(AuthorFormDto authorFormDto) {
		this.authorNameKo = authorFormDto.getAuthorNameKo();
		this.authorNameEg = authorFormDto.getAuthorNameEg();
		this.title = authorFormDto.getTitle();
		this.authorIntroduction = authorFormDto.getAuthorIntroduction();
	}

}
