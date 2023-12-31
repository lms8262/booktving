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
@Table(name = "commutation_ticket")
@Getter
@Setter
@ToString
public class CommutationTicket{
	
	@Id
	@Column(name = "commutation_ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String commutationName;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer usePeriod;
	
}
