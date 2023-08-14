package com.ezen.booktving.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional // 쿼리문 수정시 에러가 발생하면 변경된 데이터를 이전상태로 출력
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
	private final MemberRepository memberRepository;

	public Member saveMember(Member member) {
		validateDuplicateMember(member);// 이메일중복 체크
		Member savedMember = memberRepository.save(member);// insert
		return savedMember;// 회원가입된 데이터를 리턴해준다.
	}
	private void validateDuplicateMember(Member member) {

		Member findMember = memberRepository.findByUserId(member.getUserId());
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
