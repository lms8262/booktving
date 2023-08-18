package com.ezen.booktving.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.BestSeller;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.NewBookTving;
import com.ezen.booktving.repository.BestSellerRepository;
import com.ezen.booktving.repository.BookRepository;
import com.ezen.booktving.repository.NewBookTvingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiService {

	private final BestSellerRepository bestSellerRepository;
	private final NewBookTvingRepository newBookTvingRepository;
	private final BookRepository bookRepository;
	
	//main 페이지 - 서점 베스트셀러 api
    public String getBestSeller(String result) throws ParseException  {

        JSONArray list = null;
        
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        list = (JSONArray) jsonObject.get("item");
        
        for (int k = 0; k < list.size(); k++) {
        	JSONObject contents = (JSONObject) list.get(k);
        	
            bestSellerRepository.save(
                    BestSeller.builder()
                            .title(contents.get("title").toString())
                            .isbn(contents.get("isbn").toString())
                            .author(contents.get("author").toString())
                            .publisher(contents.get("publisher").toString())
                            .bestRank(contents.get("bestRank").toString())
                            .link(contents.get("link").toString())
                            .imgUrl(contents.get("cover").toString())
                            .build()
            );
        }
        return "ok";
      
    }
    
    //main 페이지 - NEW 북티빙 api
    public String getNewBookTving(String result) throws ParseException {
    	
    	JSONArray list = null;
    	
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jSONObject = (JSONObject)jsonParser.parse(result) ;
    	list = (JSONArray) jSONObject.get("item");
    	
    	for(int k = 0; k < list.size(); k++) {
    		JSONObject contents = (JSONObject) list.get(k);
    		
    		newBookTvingRepository.save(
    				NewBookTving.builder()
    							.title(contents.get("title").toString())
    							.isbn(contents.get("isbn").toString())
    							.author(contents.get("author").toString())
    							.publisher(contents.get("publisher").toString())
    							.imgUrl(contents.get("cover").toString())
    							.link(contents.get("link").toString())
    							.build()
    				);    		
    	}
    	return "ok";
    }
    
    // 알라딘 검색 api -> 검색한 책 리스트 isbn만 가져오기
    // 나중에 예외처리 해줘야함
    public List<String> getSearchBookIsbnList(BookSearchDto bookSearchDto, int startIndex, int itemsPerPage) throws UnsupportedEncodingException, IOException, ParseException{
    	String requestUrl = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx";
    	String ttbKey = "ttblyczang41056001";
    	String query = bookSearchDto.getSearchQuery();
    	String queryType = bookSearchDto.getSearchBy();
    	int start = startIndex;
    	int maxResults = itemsPerPage;
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(requestUrl);
    	sb.append("?TTBKey=");
    	sb.append(ttbKey); // 필수
    	sb.append("&Query=");
    	sb.append(query); // 필수
    	sb.append("&QueryType=");
    	sb.append(queryType);
    	sb.append("&Start=");
    	sb.append(start);
    	sb.append("&MaxResults=");
    	sb.append(maxResults);
    	sb.append("&Cover=");
    	sb.append(cover);
    	sb.append("&Output=");
    	sb.append(output);
    	sb.append("&Version=");
    	sb.append(version);
    	
    	URL url = new URL(sb.toString());
    	BufferedReader bf;
    	bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
    	String result = bf.readLine();
    	
    	JSONArray list = null;
    	JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        list = (JSONArray) jsonObject.get("item");
    	
        List<String> searchBookIsbnList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
        	JSONObject contents = (JSONObject) list.get(i);
        	String isbn13 = contents.get("isbn13").toString();
        	if(isbn13 == null || isbn13 == "") { // isbn13 값 없으면 넘김
        		continue;
        	}
        	searchBookIsbnList.add(isbn13);
        }
    	
    	return searchBookIsbnList;
    }
    
    // 알라딘 책 정보 조회 및 저장api
    // 나중에 예외처리 해줘야함
    public void getBookInfoByAladinApi(String isbn13) throws UnsupportedEncodingException, IOException, ParseException {
    	String requestUrl = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx";
    	String ttbKey = "ttblyczang41056001";
    	String itemId = isbn13;
    	String itemIdType = "ISBN13";
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	String optResult = "authors,Toc";
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(requestUrl);
    	sb.append("?TTBKey=");
    	sb.append(ttbKey); // 필수
    	sb.append("&ItemId=");
    	sb.append(itemId); // 필수
    	sb.append("&ItemIdType=");
    	sb.append(itemIdType);
    	sb.append("&Cover=");
    	sb.append(cover);
    	sb.append("&Output=");
    	sb.append(output);
    	sb.append("&Version=");
    	sb.append(version);
    	sb.append("&OptResult=");
    	sb.append(optResult);
    	
    	URL url = new URL(sb.toString());
    	BufferedReader bf;
    	bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
    	String result = bf.readLine();
    	
    	JSONArray list = null;
    	JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
    	// 여기 해야함
    }
}

