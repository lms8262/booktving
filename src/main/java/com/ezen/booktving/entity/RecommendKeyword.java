package com.ezen.booktving.entity;

import java.time.LocalDateTime;

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
@Table(name = "recommend_keyword")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendKeyword extends BaseTimeEntity {
	
	@Id
	@Column(name = "recommend_keyword_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String recommendKeywordType;
	
	@Column(nullable = false, unique = true)
	private String recommendKeywordName;

	public void pullUpRecommendKeyword() {
		this.setUpdateTime(LocalDateTime.now());
	}
}
