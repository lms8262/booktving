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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "author_book_img")
@Getter
@Setter
@ToString
public class AuthorBookImg  extends BaseTimeEntity {

	@Id
	@Column(name = "author_book_img_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String imgName;
	
	@Column(nullable = false)
	private String oriImgName;
		
	@Column(nullable = false)
	private String imgUrl;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "author_book_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AuthorBook authorBook;
	
	public void updateAuthorImg(String oriImgName, String imgName, String imgUrl) {
		this.oriImgName = oriImgName;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}
}
