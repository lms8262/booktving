package com.ezen.booktving.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.auth.PrincipalDetails;
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
	private final ModelMapper modelMapper;
	private final MemberRepository memberRepository;

	// 회원 테이블 회원등록
	public Long saveMember(MemberFormDto memberFormDto) throws Exception {
		Member member = memberFormDto.createMember(modelMapper);
		memberRepository.save(member);
		return member.getId();
	}

	public void createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		validateDuplicateUserId(memberFormDto); /// 아이디중복 체크
		validateDuplicateEmail(memberFormDto);// 이메일 중복
		validateDuplicateTel(memberFormDto);// 전화 번호 중복
		Member member = Member.createMember(memberFormDto, passwordEncoder);
		memberRepository.save(member);// insert

	}

	public Member findByUserId(String id) {
		return memberRepository.findByUserId(id);
	}

	// 중복아이디
	private void validateDuplicateUserId(MemberFormDto memberFormDto) {

		Member findMember = memberRepository.findByUserId(memberFormDto.getUserId());

		if (findMember != null) {
			throw new IllegalStateException("이미 사용중인 ID입니다.");
		}
	}

	// 중복이메일
	private void validateDuplicateEmail(MemberFormDto memberFormDto) {

		Member findMember = memberRepository.findByEmail(memberFormDto.getEmail());
		if (findMember != null) {
			throw new IllegalStateException("이미 사용중인 이메일입니다.");
		}

	}

	// 중복전화번호
	private void validateDuplicateTel(MemberFormDto memberFormDto) {

		Member findMember = memberRepository.findByTel(memberFormDto.getTel());
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
		
		return new PrincipalDetails(member);
	}

	public void deleteMenu(String userId) {
		Member member = memberRepository.findByUserId(userId);
		memberRepository.delete(member);
	}

	//회원정보 가져오기
	@Transactional(readOnly = true)
	public MemberFormDto getUpdateDtl(String userId) {
		Member member = memberRepository.findByUserId(userId);
		MemberFormDto memberFormDto = MemberFormDto.of(member, modelMapper);

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
	
	//로그인한 사용자 이름 가져오기
	public String getLoginMemberName(String userId){
		
		Member user = memberRepository.findByUserId(userId);
		
		return user.getMemberName();
	}
}
