package com.ezen.booktving.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezen.booktving.dto.NoticeSearchDto;
import com.ezen.booktving.entity.Notice;
import com.ezen.booktving.service.NoticeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeService noticeService;

	//공지사항 페이지 보여주기
	@GetMapping(value = {"/notice", "/notice/{page}"})
	public String notice(NoticeSearchDto noticeSearchDto, @PathVariable("page") Optional<Integer> page, Model model) {
		
		try {
			Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
			Page<Notice> notices = noticeService.getAdminNoticePage(noticeSearchDto, pageable);
			
			model.addAttribute("notices", notices);
			model.addAttribute("noticeSearchDto", noticeSearchDto);
			model.addAttribute("maxPage", 5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "notice/noticeList";
	}
}
