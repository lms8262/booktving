package com.ezen.booktving.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.NoticeDto;
import com.ezen.booktving.dto.NoticeSearchDto;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.Notice;
import com.ezen.booktving.repository.MemberRepository;
import com.ezen.booktving.repository.NoticeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {
	private final NoticeRepository noticeRepository;  
	private final ModelMapper modelMapper;
	

	//메인페이지 공지사항
	public List<Notice> getMainNoticePage(){
		List<Notice> noticePage = noticeRepository.getMainNoticePage();
		
		return noticePage;
	}
	
	//공지사항 목록(관리페이지, 사용자 이용페이지)
	@Transactional(readOnly = true)
	public Page<Notice> getAdminNoticePage(NoticeSearchDto noticeSearchDto, Pageable pageable){
		
		Page<Notice> noticePage = noticeRepository.getAdminNoticePage(noticeSearchDto, pageable);
		
		return noticePage;
	}
	
	//공지사항 등록
	@Transactional
	public Long saveNotice(NoticeDto noticeDto) throws Exception{
		
		Notice notice = noticeDto.createNotice(modelMapper);
		noticeRepository.save(notice);
		
		return notice.getId();
		
	}
	
	//공지사항 정보 가져오기
	@Transactional(readOnly = true)
	public NoticeDto getNoticeDtl(Long noticeId) {
		
		Notice notice = noticeRepository.findById(noticeId).orElseThrow(EntityNotFoundException::new);
		NoticeDto noticeDto = NoticeDto.of(notice, modelMapper);
		
		return noticeDto;
	}
	
	//공지사항 수정하기
	public Long updateNotice(NoticeDto noticeDto) throws Exception {
		Notice notice = noticeRepository.findById(noticeDto.getId()).orElseThrow(EntityNotFoundException::new);
		
		notice.updateNotice(noticeDto);
		
		return notice.getId();
	}
}
