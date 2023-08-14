package com.ezen.booktving.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.booktving.service.ApiService;

@Controller
public class MainController {
	
	@ResponseBody
	@GetMapping(value = "/")
	public String main() {
		
		return "main";
	}
	
	@ResponseBody
	@GetMapping("/api/getInfo")
	public String getInfo() {

	    int pages = 1;

	    try {

	        for (int i = 1; i <= 1; i++) {
	            String apiURL = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttblyczang41056001&QueryType=Bestseller&MaxResults=50&start=1&SearchTarget=Book&output=JS&Version=20131101";

	            URL url = new URL(apiURL);

	            BufferedReader bf;

	            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

	            var result = bf.readLine();

	            ApiService apiService = new ApiService(null);
				apiService.getInfo(result);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "ok";
	}
	

}
