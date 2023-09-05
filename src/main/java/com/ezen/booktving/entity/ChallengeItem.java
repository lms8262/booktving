package com.ezen.booktving.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ezen.booktving.constant.YesNoStatus;

import jakarta.persistence.CascadeType;
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
@Table(name = "challenge_item")
@Getter
@Setter
@ToString
public class ChallengeItem extends BaseTimeEntity {
	
	@Id
	@Column(name = "challenge_item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer targetMount;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private YesNoStatus success;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "is_active", nullable = false)
    private YesNoStatus isActive;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	
	
	public static ChallengeItem createChallengeItem(Integer targetMount, YesNoStatus success, YesNoStatus isActive) {
		
		ChallengeItem challengeItem = new ChallengeItem();
		challengeItem.setTargetMount(targetMount);
		challengeItem.setSuccess(YesNoStatus.N);
		challengeItem.setIsActive(YesNoStatus.Y);
		
		return challengeItem;
	}
}