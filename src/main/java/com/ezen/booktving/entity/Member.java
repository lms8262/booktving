package com.ezen.booktving.entity;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ezen.booktving.constant.Role;
import com.ezen.booktving.dto.MemberFormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@NoArgsConstructor
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

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String addressNo;

	@Column(nullable = false)
	private String addressDetail;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	private String provider;
	private String providerId;

	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {

		// 패스워드 암호화
		Member member = new Member();
		String password;
		if (memberFormDto.getProvider() != null) {
			password = memberFormDto.getPassword();
			member.setProvider(memberFormDto.getProvider());
			member.setProviderId(memberFormDto.getProviderId());
		} else {
			password = passwordEncoder.encode(memberFormDto.getPassword());
		}
		
		member.setUserId(memberFormDto.getUserId());
		member.setEmail(memberFormDto.getEmail());
		member.setPassword(password);
		member.setMemberName(memberFormDto.getMemberName());
		member.setTel(memberFormDto.getTel());
		member.setBirth(memberFormDto.getBirth());
		member.setAddress(memberFormDto.getAddress());
		member.setAddressNo(memberFormDto.getAddressNo());
		member.setAddressDetail(memberFormDto.getAddressDetail());
		member.setRole(Role.USER);

		return member;
	}

	// 비밀번호 업데이트
	public String updatePassword(String pass, PasswordEncoder passwordEncoder) {
		String password = passwordEncoder.encode(pass);
		this.password = password;

		return password;
	}

	//비밀번호 제외 업데이트
	public void updateMember(@Valid MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		this.memberName = memberFormDto.getMemberName();
		this.email = memberFormDto.getEmail();
		this.tel = memberFormDto.getTel();
		this.address = memberFormDto.getAddress();
		this.addressNo = memberFormDto.getAddressNo();
		this.addressDetail = memberFormDto.getAddressDetail();

	}

	//간편로그인
	@Builder(builderClassName = "MemberDetailRegister", builderMethodName = "MemberDetailRegister")
    public Member(String email, String password, String memberName, Role role) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.role = role;
    }

	 @Builder(builderClassName = "OAuth2Register", builderMethodName = "oauth2Register")
	    public Member(String email, String password, String memberName, Role role, String provider, String providerId) {
	    	this.email = email;
	        this.password = password;
	        this.memberName = memberName;
	        this.role = role;
	        this.provider = provider;
	        this.providerId = providerId;
	    }

}