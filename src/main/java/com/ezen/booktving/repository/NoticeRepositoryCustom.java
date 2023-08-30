package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.NoticeSearchDto;
import com.ezen.booktving.entity.Notice;

public interface NoticeRepositoryCustom {
	
	Page<Notice> getAdminNoticePage(NoticeSearchDto noticeSearchDto, Pageable pageable);
	
	Page<Notice> getMainNoticePage(Pageable pageable);

}
