package com.ezen.booktving.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

<<<<<<< HEAD
=======

import com.ezen.booktving.dto.BestSellerDto;
import com.ezen.booktving.service.BestSellerService;


>>>>>>> 26112e0bd9f8dbc4b8a8906c785ff7b87cd2640a
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
<<<<<<< HEAD

	@GetMapping(value = "/")
	public String main() {

		return "main";
	}

	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/api/getInfo") public String getInfo() {
	 * 
	 * int pages = 1;
	 * 
	 * try {
	 * 
	 * for (int i = 1; i <= 1; i++) { String apiURL =
	 * "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttblyczang41056001&QueryType=Bestseller&MaxResults=50&start=1&SearchTarget=Book&output=JS&Version=20131101";
	 * 
	 * URL url = new URL(apiURL);
	 * 
	 * BufferedReader bf;
	 * 
	 * bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	 * 
	 * var result = bf.readLine();
	 * 
	 * ApiService apiService = new ApiService(null); apiService.getInfo(result); } }
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return "ok"; }
	 */

=======
	

	private final BestSellerService bestSellerService;
	
	@GetMapping(value = "/")
	public String main(Optional<Integer> page, Model model) {
		
		/* List<BestSellerDto> bestSeller = bestSellerService.getBestSellerList(); */
		
		
		return "main";
	}
	
>>>>>>> 26112e0bd9f8dbc4b8a8906c785ff7b87cd2640a
}

