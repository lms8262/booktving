package com.ezen.booktving.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "challenge")
@Getter
@Setter
@ToString
public class Challenge extends BaseTimeEntity {

	@Id
	@Column(name = "challenge_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	
	@OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ChallengeItem> challengeItems = new ArrayList<>();
	
	public void addChallengeItem(ChallengeItem challengeItem) {
		this.challengeItems.add(challengeItem);
		challengeItem.setChallenge(this);
	}
	
	public static Challenge createChallenge(Member member, List<ChallengeItem> challengeItemList) {
		Challenge challenge = new Challenge();
		challenge.setMember(member);
		
		for(ChallengeItem challengeItem : challengeItemList) {
			challenge.addChallengeItem(challengeItem);
		}
		
		challenge.setRegTime(LocalDateTime.now());
		
		return challenge;
	}
}
