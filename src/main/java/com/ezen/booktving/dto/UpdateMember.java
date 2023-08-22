package com.ezen.booktving.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.ezen.booktving.entity.Member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMember {
	@NotBlank(message = "이름은 필수 입력 값입니다.")
	private String memberName;

	@Length(min = 8, max = 16, message = "비밀번호는 8자 ~ 16자 사이로 입력해주세요.")
	@NotNull(message = "비밀번호는 필수 입력 값입니다.")
	private String password;

	@Email(message = "이메일 형식으로 입력해주세요.")
	@NotBlank(message = "이메일은 필수 입력 값입니다.")
	private String email;

	@NotEmpty(message = "전화번호는 필수 입력 값입니다.")
	private String tel;

	@NotEmpty(message = "주소는 필수 입력 값입니다.")
	private String address;

	@NotNull(message = "생년월일은 필수 입력 값입니다.")
	private LocalDate birth;

	private static ModelMapper modelMapper = new ModelMapper();

	public static UpdateMember of(Member member) {
		// TODO Auto-generated method stub
		return modelMapper.map(member, UpdateMember.class);
	}

	public String getuserId() {
		// TODO Auto-generated method stub
		return null;
	}
}
