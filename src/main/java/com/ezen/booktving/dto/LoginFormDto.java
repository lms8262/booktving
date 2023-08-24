package com.ezen.booktving.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginFormDto {
	@NotBlank(message = "아이디는 필수 입력 값입니다.")
	private String userId;
	
	@NotBlank(message = "이름은 필수 입력 값입니다.")
	private String memberName;

	@Email(message = "이메일 형식으로 입력해주세요")
	@NotEmpty(message = "이메일은 필수 입력 값입니다.")
	private String email;

	@Length(min = 8, max = 20, message = "비밀번호는 8자 ~ 20자 사이로 입력해주세요.")
	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
	private String password;
	
	@NotEmpty(message = "전화번호는 필수 입력 값입니다.")
	private String tel;
	@NotBlank(message = "주소는 필수 입력 값입니다.")
	private String address;
	private LocalDate birth;
	
	
}
