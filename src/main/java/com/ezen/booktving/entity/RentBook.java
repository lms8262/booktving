package com.ezen.booktving.entity;

import java.time.LocalDateTime;

import com.ezen.booktving.constant.YesNoStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "rent_book")
@Getter
@Setter
@ToString
public class RentBook extends BaseTimeEntity {
	
	@Id
	@Column(name = "rent_book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime rentDate;
	
	private String review;
	
	private String sentence;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private YesNoStatus completeYn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
	
}
