package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.KeywordDto;
import com.ezen.booktving.dto.KeywordFormDto;
import com.ezen.booktving.entity.RecommendKeyword;
import com.ezen.booktving.repository.RecommendKeywordRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class KeyWordService {
	
	private final RecommendKeywordRepository recommendKeywordRepository;
	
	// 신규 추천 키워드 등록
	public void appendRecommendKeyword(KeywordFormDto keywordFormDto) {
		RecommendKeyword recommendKeyword = recommendKeywordRepository.findByRecommendKeywordName(keywordFormDto.getKeywordName());
		if(recommendKeyword != null) {
			throw new RuntimeException("이미 존재하는 추천 키워드입니다.");
		}
		
		recommendKeyword = RecommendKeyword.builder()
										   .recommendKeywordType(keywordFormDto.getKeywordType())
										   .recommendKeywordName(keywordFormDto.getKeywordName())
										   .build();
		recommendKeywordRepository.save(recommendKeyword);
	}
	
	// 페이징 처리 가능한 추천 키워드 리스트 가져오기
	public Page<KeywordDto> getRecommendKeywordList(String searchKeywordName, Pageable pageable) {
		Page<RecommendKeyword> recommendKeywordList = recommendKeywordRepository.getRecommendKeywordList(searchKeywordName, pageable);
		List<KeywordDto> keywordDtoList = recommendKeywordList.getContent().stream().map(KeywordDto::createKeywordDto).collect(Collectors.toList());
		
		return new PageImpl<>(keywordDtoList, pageable, keywordDtoList.size());
	}
}
