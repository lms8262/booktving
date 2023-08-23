package com.ezen.booktving.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ezen.booktving.entity.BestSeller;
import com.ezen.booktving.entity.NewBookTving;
import com.ezen.booktving.repository.BestSellerRepository;
import com.ezen.booktving.repository.NewBookTvingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiService {

	private final BestSellerRepository bestSellerRepository;
	private final NewBookTvingRepository newBookTvingRepository;

	//main 페이지 - 서점 베스트셀러 api
    public void getBestSeller(String result) throws ParseException  {

        JSONArray list = null;
        
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        list = (JSONArray) jsonObject.get("item");
        
        for (int k = 0; k < list.size(); k++) {
        	JSONObject contents = (JSONObject) list.get(k);
        	
        	String aladinApiAuthor = contents.get("author").toString();
            String processedAuthor = extractAuthorName(aladinApiAuthor);
        	
            bestSellerRepository.save(
                    BestSeller.builder()
                            .title(contents.get("title").toString())
                            .isbn(contents.get("isbn13").toString())
                            .author(processedAuthor)
                            .publisher(contents.get("publisher").toString())
                            .bestRank(contents.get("bestRank").toString())
                            .link(contents.get("link").toString())
                            .imgUrl(contents.get("cover").toString())
                            .build()
            );
        }
    }
    
    //main 페이지 - NEW 북티빙 api
    public void getNewBookTving(String result) throws ParseException {
    	
    	JSONArray list = null;
    	
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jSONObject = (JSONObject) jsonParser.parse(result) ;
    	list = (JSONArray) jSONObject.get("item");
    	
    	for(int k = 0; k < list.size(); k++) {
    		JSONObject contents = (JSONObject) list.get(k);
    		
    		String aladinApiAuthor = contents.get("author").toString();
    		String processedAuthor = extractAuthorName(aladinApiAuthor);
    		
    		newBookTvingRepository.save(
    				NewBookTving.builder()
    							.title(contents.get("title").toString())
    							.isbn(contents.get("isbn13").toString())
    							.author(processedAuthor)
    							.publisher(contents.get("publisher").toString())
    							.imgUrl(contents.get("cover").toString())
    							.link(contents.get("link").toString())
    							.build()
    		);    		
    	}
    }

    //저자명 (지은이) 잘라서 데이터 저장하기
    private String  extractAuthorName(String author) {
    	String[] parts = author.split("\\(");
    	if(parts.length > 0) {
    		return parts[0].trim();
    	}
    	return author.trim();
    }
   
    
}

