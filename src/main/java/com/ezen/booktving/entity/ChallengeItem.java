package com.ezen.booktving.entity;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "challenge_id", nullable = false)
	private Challenge challenge;
	
	
	public static ChallengeItem challengeItem(Integer targetMount, YesNoStatus success, Challenge challenge ) {
		
		ChallengeItem challengeItem = new ChallengeItem();
		challengeItem.setChallenge(challenge);
		challengeItem.setTargetMount(targetMount);
		challengeItem.setSuccess(success);
		
		return challengeItem;
	}
}
