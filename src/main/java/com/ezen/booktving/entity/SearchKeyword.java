package com.ezen.booktving.entity;

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
@Table(name = "search_keyword")
@Getter
@Setter
@ToString
public class SearchKeyword extends BaseTimeEntity {
	
	@Id
	@Column(name = "search_keyword_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String searchKeywordType;
	
	@Column(nullable = false)
	private String searchKeywordName;
	
}
