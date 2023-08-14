package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

<<<<<<< HEAD
=======

import lombok.RequiredArgsConstructor;

>>>>>>> 6b6b566495e6435166a315181c1b014c688d61f0
@Controller
@RequiredArgsConstructor
public class MainController {
	
	
<<<<<<< HEAD
=======
	
>>>>>>> 6b6b566495e6435166a315181c1b014c688d61f0
	@GetMapping(value = "/")
	public String main() {
		
		
		
		
		return "main";
	}
	
<<<<<<< HEAD
	/*
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
	*/
=======

	
>>>>>>> 6b6b566495e6435166a315181c1b014c688d61f0
	

}
