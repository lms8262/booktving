package com.ezen.booktving.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.entity.BestSeller;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;
import com.ezen.booktving.entity.NewBookTving;
import com.ezen.booktving.repository.BestSellerRepository;
import com.ezen.booktving.repository.BookImgRepository;
import com.ezen.booktving.repository.BookRepository;
import com.ezen.booktving.repository.NewBookTvingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiService {
	
	private final WebClient aladinWebClient;
	private final BestSellerRepository bestSellerRepository;
	private final NewBookTvingRepository newBookTvingRepository;
	private final BookRepository bookRepository;
	private final BookImgRepository bookImgRepository;
	
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
    
    // db에 저장된 책인지 isbn으로 확인
    private boolean validateDuplicateIsbn(String isbn) {
    	Book book = bookRepository.findByIsbn(isbn);
    	if(book != null) { // db에 존재하면
    		return false; 
    	}
    	
    	return true;
    }
    
    // 알라딘 검색 api -> 검색한 책 리스트 isbn만 가져오기
    public List<String> getSearchBookIsbnList(BookSearchDto bookSearchDto, int startIndex, int itemsPerPage) throws JsonMappingException, JsonProcessingException {
    	String ttbKey = "ttblyczang41056001";
    	String query = bookSearchDto.getSearchQuery();
    	String queryType = bookSearchDto.getSearchBy();
    	int start = startIndex;
    	int maxResults = itemsPerPage;
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	
    	String result = aladinWebClient.get()
    	.uri(uriBuilder -> uriBuilder
    			.path("/ItemSearch.aspx")
    			.queryParam("ttbKey", ttbKey)
    			.queryParam("Query", query)
    			.queryParam("QueryType", queryType)
    			.queryParam("Start", start)
    			.queryParam("MaxResults", maxResults)
    			.queryParam("Cover", cover)
    			.queryParam("Output", output)
    			.queryParam("Version", version)
    			.build()
    		)
    	.retrieve()
    	.bodyToMono(String.class)
    	.block();
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(result);
        
        List<String> searchBookIsbnList = new ArrayList<>();
        for(JsonNode itemNode : rootNode.get("item")) {
        	String isbn13 = itemNode.get("isbn13").textValue();
        	if(isbn13.equals("") || isbn13 == null) {
        		continue;
        	}
        	searchBookIsbnList.add(isbn13);
        }
    	
    	return searchBookIsbnList;
    }
    
    // 알라딘 책 정보 조회 및 저장api
    public void getBookInfoByAladinApi(String isbn) throws JsonMappingException, JsonProcessingException {
    	if(!validateDuplicateIsbn(isbn)) {
    		return;
    	}
    	
    	String ttbKey = "ttblyczang41056001";
    	String itemId = isbn;
    	String itemIdType = "ISBN13";
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	String optResult = "authors,Toc";
    	
    	String result = aladinWebClient.get()
    	    	.uri(uriBuilder -> uriBuilder
    	    			.path("/ItemLookUp.aspx")
    	    			.queryParam("ttbKey", ttbKey)
    	    			.queryParam("ItemId", itemId)
    	    			.queryParam("ItemIdType", itemIdType)
    	    			.queryParam("Cover", cover)
    	    			.queryParam("Output", output)
    	    			.queryParam("Version", version)
    	    			.queryParam("OptResult", optResult)
    	    			.build()
    	    		)
    	    	.retrieve()
    	    	.bodyToMono(String.class)
    	    	.block();
    	
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(result);
        JsonNode itemNode = null;
        for(JsonNode item : rootNode.get("item")) {
        	itemNode = item;
        	break;
        }
       
        Book book = Book.builder()
        		.bookName(itemNode.get("title").textValue())
        		.isbn(itemNode.get("isbn13").textValue())
        		.authorName(itemNode.get("subInfo").get("authors").get(0).get("authorName").textValue())
        		.publisher(itemNode.get("publisher").textValue())
        		.page(itemNode.get("subInfo").get("itemPage").intValue())
        		.publicationDate(LocalDate.parse(itemNode.get("pubDate").textValue(), DateTimeFormatter.ISO_DATE))
        		.bookIntroduction(itemNode.get("description").textValue())
        		.contents(itemNode.get("subInfo").get("toc").textValue())
        		.category(itemNode.get("categoryName").textValue())
        		.authorInfo(itemNode.get("subInfo").get("authors").get(0).get("authorInfo").textValue())
        		.build();
        
        bookRepository.save(book);
        
        String imgUrl = itemNode.get("cover").textValue();
        String oriImgName = imgUrl.substring(imgUrl.lastIndexOf("/"));
        String extension = oriImgName.substring(oriImgName.lastIndexOf("."));
        UUID uuid = UUID.randomUUID();
        String imgName = uuid.toString() + extension;
        
        BookImg bookImg = BookImg.builder()
        						.imgName(imgName)
        						.oriImgName(oriImgName)
        						.repYn(YesNoStatus.Y)
        						.imgUrl(itemNode.get("cover").textValue())
        						.book(book)
        						.build();
        
        bookImgRepository.save(bookImg);
    }
    
}

