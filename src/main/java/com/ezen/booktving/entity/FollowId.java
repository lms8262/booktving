package com.ezen.booktving.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowId implements Serializable {
	
	private Long fromUserId;
	
	private Long toUserId;
}
