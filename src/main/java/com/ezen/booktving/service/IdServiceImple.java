package com.ezen.booktving.service;

import org.springframework.stereotype.Service;

import com.ezen.booktving.dto.MemberFormDto;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.repository.MemberRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdServiceImple implements IdService {

	private final MemberRepository memberRepository;
	
	
	@Override
	public String finduserId(String memberName, String email) {
		String result = "";
		try {
			Member member = memberRepository.findByMemberNameAndEmail(memberName, email);
			result = member.getUserId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}




	



	


	






	/*
	 * private final MemberRepository memberRepository;
	 * 
	 * @Override public String findId(String memberName, String email) {
	 * 
	 * String result = "";
	 * 
	 * try { result = memberRepository.findId(memberName, email);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return result; }
	 */
}
