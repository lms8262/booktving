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
public class MemberFormDto {
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
	
	@NotNull(message = "생년월일은 필수 입력 값입니다.")
	private LocalDate birth;

	@NotBlank(message = "주소는 필수 입력 값입니다.")
	private String address;
	
	@NotBlank(message = "우편번호는 필수 입력 값입니다.")
	private String addressNo;
	
	@NotBlank(message = "상세주소는 필수 입력 값입니다.")
	private String addressDetail;

	private String provider;
	private String providerId;

	public static MemberFormDto of(Member member, ModelMapper modelMapper) {
		return modelMapper.map(member, MemberFormDto.class);
	}

	public Member createMember(ModelMapper modelMapper) {
		return modelMapper.map(this, Member.class);

	}

}
