package com.ezen.booktving.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.booktving.dto.KeywordDto;
import com.ezen.booktving.dto.KeywordFormDto;
import com.ezen.booktving.entity.RecommendKeyword;
import com.ezen.booktving.repository.RecommendKeywordRepository;
import com.ezen.booktving.repository.SearchKeywordRepositiory;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class KeyWordService {
	
	private final RecommendKeywordRepository recommendKeywordRepository;
	private final SearchKeywordRepositiory searchKeywordRepositiory;
	
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
	@Transactional(readOnly = true)
	public Page<KeywordDto> getRecommendKeywordList(String searchKeywordName, Pageable pageable) {
		Page<RecommendKeyword> recommendKeywordList = recommendKeywordRepository.getRecommendKeywordList(searchKeywordName, pageable);
		List<KeywordDto> keywordDtoList = recommendKeywordList.getContent().stream().map(KeywordDto::createKeywordDto).collect(Collectors.toList());
		
		return new PageImpl<>(keywordDtoList, pageable, recommendKeywordList.getTotalElements());
	}
	
	// 추천 키워드 끌어올리기
	public void pullUpRecommendKeyword(List<Long> keywordIdList) {
		List<RecommendKeyword> recommendKeywordList = new ArrayList<>();
		for(Long keywordId : keywordIdList) {
			RecommendKeyword recommendKeyword = recommendKeywordRepository.findById(keywordId).orElseThrow(EntityNotFoundException::new);
			recommendKeyword.pullUpRecommendKeyword();
			recommendKeywordList.add(recommendKeyword);
		}
		
		recommendKeywordRepository.saveAll(recommendKeywordList);
	}
	
	// 추천 키워드 삭제하기
	public void deleteRecommendKeyword(List<Long> keywordIdList) {
		List<RecommendKeyword> recommendKeywordList = new ArrayList<>();
		for(Long keywordId : keywordIdList) {
			RecommendKeyword recommendKeyword = recommendKeywordRepository.findById(keywordId).orElseThrow(EntityNotFoundException::new);
			recommendKeywordList.add(recommendKeyword);
		}
		
		recommendKeywordRepository.deleteAll(recommendKeywordList);
	}
	
	// searchMain 페이지에 보여줄 추천 키워드 15개(최신순)
	@Transactional(readOnly = true)
	public List<KeywordDto> getRecommendKeywordLatest15() {
		List<RecommendKeyword> recommendKeywordList = recommendKeywordRepository.findTop15ByOrderByUpdateTimeDesc();
		
		List<KeywordDto> keywordDtoList = new ArrayList<>();
		for(RecommendKeyword recommendKeyword : recommendKeywordList) {
			KeywordDto keywordDto = KeywordDto.createKeywordDtoOfSearchMain(recommendKeyword);
			keywordDtoList.add(keywordDto);
		}
		
		return keywordDtoList;
	}
	
	// 인기 키워드 관리 페이지에 보여줄 DB 검색 순위 Top
	@Transactional(readOnly = true)
	public List<KeywordDto> getSearchKeywordTop(Long limit) {
		return searchKeywordRepositiory.getSearchKeywordTop(limit);
	}
	
	// searchMain 페이지에 보여줄 인기 키워드 Top(출판사 제외)
	@Transactional(readOnly = true)
	public List<String> getSearchKeywordNameTop(Long limit) {
		return searchKeywordRepositiory.getSearchKeywordNameTop(limit);
	}
	
}
