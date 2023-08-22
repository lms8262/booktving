package com.ezen.booktving.entity;


import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "author")
@Getter
@Setter
@ToString
public class Author{
	
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
	
	@Column(nullable = false)
	private String imgName;
	
	@Column(nullable = false)
	private String oriImgName;
		
	@Column(nullable = false)
	private String imgUrl;

}
