package com.ezen.booktving.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookReviewDto {

	private Long id;

	private String userId;
	
	@NotBlank(message = "내용은 필수 입니다.")
	@Length(min = 2, max = 50, message = "리뷰는 반드시 2자 이상 입력해주세요.")
	private String content;

}