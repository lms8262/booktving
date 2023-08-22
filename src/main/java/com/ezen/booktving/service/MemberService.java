package com.ezen.booktving.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.LoginFormDto;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional // 쿼리문 수정시 에러가 발생하면 변경된 데이터를 이전상태로 출력
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	public void createMember(LoginFormDto loginFormDto) {
		validateDuplicateUserId(loginFormDto); /// 아이디중복 체크
		validateDuplicateEmail(loginFormDto);// 이메일 중복
		validateDuplicateTel(loginFormDto);// 전화 번호 중복
		Member member = Member.createMember(loginFormDto, passwordEncoder);
		memberRepository.save(member);// insert

	}

	// 중복아이디

	private void validateDuplicateUserId(LoginFormDto loginFormDto) {

		Member findMember = memberRepository.findByUserId(loginFormDto.getEmail());
		if (findMember != null) {
			throw new IllegalStateException("이미 사용중인 이메일입니다.");
		}
	}

	// 중복이메일
	private void validateDuplicateEmail(LoginFormDto loginFormDto) {

		Member findMember = memberRepository.findByEmail(loginFormDto.getEmail());
		if (findMember != null) {
			throw new IllegalStateException("이미 사용중인 이메일입니다.");
		}

	}

	// 중복전화번호
	private void validateDuplicateTel(LoginFormDto loginFormDto) {

		Member findMember = memberRepository.findByTel(loginFormDto.getTel());
		if (findMember != null) {
			throw new IllegalStateException("이미 사용중인 전화번호입니다.");
		}

	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Member member = memberRepository.findByUserId(userId);

		if (member == null) {
			throw new UsernameNotFoundException(userId);
		}
		return User.builder().username(member.getUserId()).password(member.getPassword())
				.roles(member.getRole().toString()).build();
	}

	


}