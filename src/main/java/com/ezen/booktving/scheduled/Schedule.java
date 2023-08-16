package com.ezen.booktving.scheduled;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ezen.booktving.service.ApiService;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class Schedule {
	
	private final ApiService apiService;
	
	//main페이지 - 서점 베스트셀러 api
	//@Scheduled(fixedDelay = 10000)
	@Scheduled(cron = " 30 * * * * *")
	public void getBestSeller() {
		
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
	
	//main 페이지 - NEW 북티빙 api
	@Scheduled(cron = " 0 30 10 * * *")
	public void getNewBookTving() {
			
		try {
				String apiURL = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttblyczang41056001&QueryType=ItemNewSpecial&MaxResults=50&Cover=Big&start=1&SearchTarget=Book&output=JS&Version=20131101";
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

