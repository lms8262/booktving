package com.ezen.booktving.postConstruct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.ezen.booktving.repository.BestSellerRepository;
import com.ezen.booktving.repository.NewBookTvingRepository;
import com.ezen.booktving.service.ApiService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitialDataLoader {
	//"main 페이지" 에서 작업한 '베스트셀러', '신간리스트' 등등 알라딘 api 데이터 처음 받아오는 로직 

	private final ApiService apiService;
	private final BestSellerRepository bestSellerRepository;
	private final NewBookTvingRepository newBookTvingRepository;
	
	//서점 베스트셀러 api 데이터 받아오기	
	@PostConstruct
	public void getBestSeller() {
		
		if(!dataExistsInDatabase1()) {
			
			try {
				String apiURL = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttblyczang41056001&QueryType=Bestseller&MaxResults=10&Cover=Big&start=1&SearchTarget=Book&output=JS&Version=20131101";
				URL url = new URL(apiURL);
				
				BufferedReader bf;
				bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				String result = bf.readLine();
				
				apiService.getBestSeller(result);
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		
	}
	
	//서점 베스트셀러 데이터 1번만 받아오게 하는 메소드
	private boolean dataExistsInDatabase1() {
		
		long count = bestSellerRepository.count();
		
		return count > 0;
	}

	
	
	//NEW 북티빙 api 
	@PostConstruct
	public void getNewBookTving() {
		
		if(!dataExistsInDatabase2()) {
			try {
				String apiURL = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttblyczang41056001&QueryType=ItemNewSpecial&MaxResults=10&Cover=Big&start=1&SearchTarget=Book&output=JS&Version=20131101";
				URL url = new URL(apiURL);
	
	            BufferedReader bf;
	            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	            String result = bf.readLine();
	
				apiService.getNewBookTving(result);
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//NEW 북티빙 데이터 1번만 받아오게 하는 메소드
	private boolean dataExistsInDatabase2() {
		
		long count = newBookTvingRepository.count();
		
		return count > 0;
	}
}
