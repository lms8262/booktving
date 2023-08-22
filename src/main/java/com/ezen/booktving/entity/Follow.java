package com.ezen.booktving.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "follow")
@Getter
@Setter
@ToString
@IdClass(FollowId.class)
public class Follow extends BaseTimeEntity {
	
	@Id
	@Column(name = "from_user_id")
	private Long fromUserId;
	
	@Id
	@Column(name = "to_user_id")
	private Long toUserId;
}
