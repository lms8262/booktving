package com.ezen.booktving.entity;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ezen.booktving.constant.PrivateOk;
import com.ezen.booktving.constant.PromotionOk;
import com.ezen.booktving.constant.Role;
import com.ezen.booktving.constant.ServiceOk;
import com.ezen.booktving.dto.LoginFormDto;
import com.ezen.booktving.dto.MemberFormDto;
import com.ezen.booktving.dto.SnsDto;

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
	private String name;
	private String provider;
	private String providerId;

	@Enumerated(EnumType.STRING) // 서비스 동의
	private ServiceOk serviceOk;

	@Enumerated(EnumType.STRING) // 개인정보 동의
	private PrivateOk privateOk;

	@Enumerated(EnumType.STRING) // 프로모션 동의
	private PromotionOk promotionOk;

	public static Member createMember(LoginFormDto loginFormDto, PasswordEncoder passwordEncoder) {

		// 패스워드 암호화
		Member member = new Member();
		String password;
		if (loginFormDto.getPassword().equals("SNS 로그인")) {
			password = "SNS 로그인";
			member.setProvider(loginFormDto.getProvider());
			member.setProviderId(loginFormDto.getProviderId());
		} else {
			password = passwordEncoder.encode(loginFormDto.getPassword());
		}

		member.setEmail(loginFormDto.getEmail());
		member.setPassword(password);
		member.setMemberName(loginFormDto.getMemberName());
		member.setTel(loginFormDto.getTel());
		member.setBirth(loginFormDto.getBirth());
		member.setRole(Role.ROLE_USER);

		if (loginFormDto.getMemberName().isEmpty()) {
			member.setMemberName(loginFormDto.getMemberName());
		} else {
			member.setMemberName(loginFormDto.getMemberName());
		}

		return member;
	}

	// sns회원가입 메소드
	public static Member createSnsMember(SnsDto snsDto) {
		Member member = new Member();

		// 기본정보
		member.setMemberName(snsDto.getNickname());
		member.setEmail(snsDto.getEmail());
		member.setPassword(snsDto.getPassword());
		member.setTel(snsDto.getPhoneNumber());
		member.setName(snsDto.getName()); // 간편로그인시 소셜회사마다 주는 회원이름값
		member.setProvider(snsDto.getProvider()); // 구글인지 카카오인지 구별값
		member.setProviderId(snsDto.getProviderId()); // 소셜 기본id값

		// 약관동의
		member.setServiceOk(ServiceOk.Y);
		member.setPrivateOk(PrivateOk.Y);
		member.setPromotionOk(PromotionOk.Y);

		// 역할
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
		this.email = memberFormDto.getEmail();
		this.tel = memberFormDto.getTel();
		this.address = memberFormDto.getAddress();

		// 생년월일 업데이트 작업 수행
		this.birth = memberFormDto.getBirth();

		// 비밀번호 업데이트 작업 수행
		if (memberFormDto.getPassword() != null) {
			this.password = passwordEncoder.encode(memberFormDto.getPassword());
		}
	}

//간편로그인
	@Builder(builderClassName = "MemberDetailRegister", builderMethodName = "MemberDetailRegister")
    public Member(String email, String password, String name, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

	 @Builder(builderClassName = "OAuth2Register", builderMethodName = "oauth2Register")
	    public Member(String email, String password, String name, Role role, String provider, String providerId) {
	    	this.email = email;
	        this.password = password;
	        this.name = name;
	        this.role = role;
	        this.provider = provider;
	        this.providerId = providerId;
	    }

}
