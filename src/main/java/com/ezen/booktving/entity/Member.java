package com.ezen.booktving.entity;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ezen.booktving.constant.Role;
import com.ezen.booktving.dto.LoginFormDto;
import com.ezen.booktving.dto.MemberFormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member extends BaseTimeEntity {
	
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String userId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String memberName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String tel;
	
	@Column(nullable = false)
	private LocalDate birth;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	public static Member createMember(LoginFormDto loginFormDto, PasswordEncoder passwordEncoder) {

		// 패스워드 암호화
		String password = passwordEncoder.encode(loginFormDto.getPassword());

		//MemberFormDto를 -> Member 엔티티 객체로 변환
		
		Member member = new Member();
		member.setUserId(loginFormDto.getUserId());
		member.setMemberName(loginFormDto.getMemberName());
		member.setEmail(loginFormDto.getEmail());
		member.setBirth(loginFormDto.getBirth());
		member.setTel(loginFormDto.getTel());
		member.setPassword(password);
		/* member.setRole(Role.ADMIN);  //관리자로 가입할때*/
		member.setRole(Role.USER);//일반 사용자로 가입할때
		
		return member;
	}

	public  void updateMember(LoginFormDto loginFormDto) {
		this.password = loginFormDto.getPassword();
	}
	public String  updatePassword(String pass,PasswordEncoder passwordEncoder) {
		String password = passwordEncoder.encode(pass);
		this.password = password;

		return password;
	}
	

	
	
}