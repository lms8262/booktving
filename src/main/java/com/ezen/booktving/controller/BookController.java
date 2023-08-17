package com.ezen.booktving.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.booktving.service.ApiService;
import com.ezen.booktving.service.BookService;

@Controller
public class BookController {

	private BookService bookService;
	private ApiService apiService;
	
	//도서상세 페이지
	@GetMapping(value = "/book/bookDetail/") //개발 후 경로 변경 {bookId}
	public String bookDetail() {
		
		return "/book/bookDetail";
	}
	
	/*@PostMapping(value = "/book/bookDetail/")
	public String bookDetail() {
		try {
			String apiURL = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=ttblyczang41056001&itemIdType=ISBN&ItemId=K342833636&output=xml&Version=20131101&OptResult=ebookList,usedList,reviewList";
		
			URL url = new URL(apiURL);
			
			BufferedReader bf;
			
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			String result = bf.readLine();
			
			apiService.getInfo(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
}
