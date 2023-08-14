package com.ezen.booktving.entity;

import com.ezen.booktving.constant.NoticeGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "notice")
@Getter
@Setter
@ToString
public class Notice extends BaseEntity {
	
	@Id
	@Column(name = "notice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "longtext", nullable = false)
	private String content;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private NoticeGroup noticeGroup;
	
}
