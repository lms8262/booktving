package com.ezen.booktving.dto;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.NoticeGroup;
import com.ezen.booktving.entity.Notice;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDto {
	
	private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private NoticeGroup noticeGroup;
	
	public Notice createNotice(ModelMapper modelMapper) {
		return modelMapper.map(this, Notice.class);
	}
	
	public static NoticeDto of(Notice notice, ModelMapper modelMapper) {
		return modelMapper.map(notice, NoticeDto.class);
	}

}
