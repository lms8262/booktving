package com.ezen.booktving.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.LoginFormDto;
import com.ezen.booktving.dto.MemberFormDto;
import com.ezen.booktving.dto.MemberSearchDto;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Transactional // 쿼리문 수정시 에러가 발생하면 변경된 데이터를 이전상태로 출력
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
	private final MemberRepository memberRepository;

	// 회원 테이블 회원등록
	public Long saveMember(MemberFormDto memberFormDto) throws Exception {
		Member member = memberFormDto.createMember();
		memberRepository.save(member);
		return member.getId();
	}

	public void createMember(LoginFormDto loginFormDto, PasswordEncoder passwordEncoder) {
		validateDuplicateUserId(loginFormDto); /// 아이디중복 체크
		validateDuplicateEmail(loginFormDto);// 이메일 중복
		validateDuplicateTel(loginFormDto);// 전화 번호 중복
		Member member = Member.createMember(loginFormDto, passwordEncoder);
		memberRepository.save(member);// insert

	}

	public Member findByUserId(String id) {
		return memberRepository.findByUserId(id);
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

	/*
	 * public Long updateMember(MemberFormDto memberFormDto) throws
	 * EntityNotFoundException { Member member =
	 * memberRepository.findById(memberFormDto.getId()).orElseThrow(
	 * EntityNotFoundException::new);
	 * 
	 * member.updateMember(memberFormDto);
	 * 
	 * 
	 * return member.getId(); }
	 */

	public void deleteMenu(String userId) {
		Member member = memberRepository.findByUserId(userId);
		memberRepository.delete(member);
	}

	//회원정보 가져오기
	@Transactional(readOnly = true)
	public MemberFormDto getUpdateDtl(String userId) {
		Member member = memberRepository.findByUserId(userId);
		MemberFormDto memberFormDto = MemberFormDto.of(member);

		return memberFormDto;
	}

	public String updateMember1(@Valid MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) throws Exception {
		Member member = memberRepository.findByUserId(memberFormDto.getUserId());
		member.updateMember(memberFormDto, passwordEncoder);
		return member.getUserId();
	}

	//회원관리
	@Transactional(readOnly = true)
	public Page<Member> getAdminMemberPage(MemberSearchDto membersearchDto, Pageable pageable) {
		Page<Member> memberPage = memberRepository.getAdminMemberPage(membersearchDto, pageable);
		return memberPage;
	}

	//회원관리 삭제
	public void deleteMember(Long memberId) {
		Member member = memberRepository.findById(memberId).orElseThrow(EntityNotFoundException::new);
		memberRepository.delete(member);
	}

	//회원정보 수정 회원탈퇴
	@Transactional
	public void deleteMember2(String userId) {
		Member member = memberRepository.findByUserId(userId);
		if (member == null) {
			throw new EntityNotFoundException("Member not found");
		}
		memberRepository.delete(member);
	}
	
	//로그인한 사용자 정보 가져오기
	public Member listAll(String userId){
		
		Member user = memberRepository.findByLogInUserId(userId);
		
		return user;
	}
	
}
