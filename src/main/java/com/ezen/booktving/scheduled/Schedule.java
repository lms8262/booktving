package com.ezen.booktving.scheduled;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ezen.booktving.repository.BestSellerRepository;
import com.ezen.booktving.repository.NewBookTvingRepository;
import com.ezen.booktving.service.ApiService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class Schedule {
	
	private final ApiService apiService;
	private final BestSellerRepository bestSellerRepository;
	private final NewBookTvingRepository newBookTvingRepository;
	
	//main페이지 - 서점 베스트셀러 api
	//@Scheduled(fixedDelay = 10000)
	@Scheduled(cron = " 0 30 10 * * *")
	public void getBestSeller() {
		
		List<String> isbnInDatabase = bestSellerRepository.findAllIsbn();
					
		try {
			String apiURL = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttblyczang41056001&QueryType=Bestseller&MaxResults=10&Cover=Big&start=1&SearchTarget=Book&output=JS&Version=20131101";
			URL url = new URL(apiURL);
				
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String result = bf.readLine();
			//System.out.println(result);
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(result);
			
			List<String> isbnsFromApi = new ArrayList<>();
				
			for(JsonNode itemNode : rootNode.get("item")) {
				String isbn = itemNode.get("isbn13").asText();
				isbnsFromApi.add(isbn);
			}
			
			for(String isbn : isbnsFromApi) {
				if(!isbnInDatabase.contains(isbn)) {
					apiService.getBestSeller(isbn);
				}
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	//main 페이지 - NEW 북티빙 api
	@Scheduled(cron = " 0 30 10 * * *")
	public void getNewBookTving() {
		
		List<String> isbnInDatabase = newBookTvingRepository.findAllIsbn();
			
		try {
				String apiURL = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttblyczang41056001&QueryType=ItemNewSpecial&MaxResults=10&Cover=Big&start=1&SearchTarget=Book&output=JS&Version=20131101";
				URL url = new URL(apiURL);

	            BufferedReader bf;
	            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	            String result = bf.readLine();
	            
	            ObjectMapper objectMapper = new ObjectMapper();
				JsonNode rootNode = objectMapper.readTree(result);
				
				List<String> isbnsFromApi = new ArrayList<>();
					
				for(JsonNode itemNode : rootNode.get("item")) {
					String isbn = itemNode.get("isbn13").asText();
					isbnsFromApi.add(isbn);
				}
				
				for(String isbn : isbnsFromApi) {
					if(!isbnInDatabase.contains(isbn)) {
						apiService.getNewBookTving(isbn);
					}
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		}

}

