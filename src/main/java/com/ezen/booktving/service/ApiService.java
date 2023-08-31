package com.ezen.booktving.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiService {
	
	private final WebClient webClient;
	private final BestSellerRepository bestSellerRepository;
	private final NewBookTvingRepository newBookTvingRepository;
	private final BookRepository bookRepository;
	private final BookImgRepository bookImgRepository;
	
	  //main 페이지 - 서점 베스트셀러 api
    public void getBestSeller(String result) throws ParseException  {

        JSONArray list = null;
        
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
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
    	JSONObject jSONObject = (JSONObject)jsonParser.parse(result) ;
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
   
    
    // 검색api 결과가 들어있는 jsonString
    private String getJsonStringOfSearchBook(BookSearchDto bookSearchDto, int start) {
    	String ttbKey = "ttblyczang41056001";
    	String query = bookSearchDto.getSearchQuery();
    	System.out.println(query);
    	String queryType = bookSearchDto.getSearchBy();
    	int maxResults = 50;
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	
		String result = webClient.get()
		    	.uri(uriBuilder -> uriBuilder
		    			.path("/ItemSearch.aspx")
		    			.queryParam("TTBKey", ttbKey)
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
		
		return result;
    }
    
    // 검색시 책 + 이미지 저장하는 메소드
    private void saveBookWhenSearch(JsonNode rootNode) throws IOException {
    	if(rootNode.get("item") == null) {
    		return;
    	}
    	
    	for(JsonNode itemNode : rootNode.get("item")) {
        	String isbn13 = itemNode.get("isbn13").textValue();
        	// isbn13이 비어있거나, db에 이미 있으면 패스
        	if(isbn13.equals("") || bookRepository.findByIsbn(isbn13) != null) {
        		continue;
        	}
        	
        	Book book = Book.builder()
        			.bookName(itemNode.get("title").textValue())
            		.isbn(itemNode.get("isbn13").textValue())
            		.author(itemNode.get("author").textValue())
            		.publisher(itemNode.get("publisher").textValue())
            		.publicationDate(LocalDate.parse(itemNode.get("pubDate").textValue(), DateTimeFormatter.ISO_DATE))
            		.bookIntroduction(itemNode.get("description").textValue())
            		.category(itemNode.get("categoryName").textValue())
            		.page(0)
            		.contents("")
            		.reqAuthor("")
            		.authorInfo("")
            		.build();
        	
        	bookRepository.save(book);
        	
        	// 이미지 path를 통해서 생성 후 저장
            String imgPath = itemNode.get("cover").textValue();
            String oriImgName = imgPath.substring(imgPath.lastIndexOf("/") + 1);
            String extension = oriImgName.substring(oriImgName.lastIndexOf("."));
            String imgName = book.getIsbn() + extension;
            String imgUrl = "/image/book/" + imgName;
            String format = extension.substring(extension.lastIndexOf(".") + 1);
            
            URL url = new URL(imgPath);
            BufferedImage image = ImageIO.read(url);
            
            ImageIO.write(image, format, new File("C:/booktving/book/" + imgName));
            
            BookImg bookImg = BookImg.builder()
            						.imgName(imgName)
            						.oriImgName(oriImgName)
            						.repYn(YesNoStatus.Y)
            						.imgUrl(imgUrl)
            						.book(book)
            						.build();
            
            bookImgRepository.save(bookImg);
        }
    }
    
    // 검색시 알라딘 검색 api로 정보 가져와서 기본정보만 저장
    public void saveBookWhenSearchByAladinApi(BookSearchDto bookSearchDto) throws IOException {
    	// 1번째 api 요청
    	String result = getJsonStringOfSearchBook(bookSearchDto, 1);
		
    	ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(result);
        
        saveBookWhenSearch(rootNode);
        if(rootNode.get("item") == null) {
    		return;
    	}
        // 총 데이터 개수에 따른 api 요청 횟수를 계산(1회당 데이터 50개)
        int totalResults = rootNode.get("totalResults").intValue();
        int totalPage = (totalResults / 50) + 1 > 4 ? 4 : (totalResults / 50);
        
        // 2번째 이후 api 요청
        if(totalPage >= 2) {
        	for(int i = 2; i <= totalPage; i++) {
        		result = getJsonStringOfSearchBook(bookSearchDto, i);
        		
        		rootNode = objectMapper.readTree(result);
        		
        		saveBookWhenSearch(rootNode);
        	}
        }
        
    }
    
    // 책 상세정보 업데이트
    @Transactional
    private void updateBookDetail(JsonNode rootNode, Book book) {
    	JsonNode itemNode = null;
        
        // 1번째 item만 꺼내오기
        for(JsonNode item : rootNode.get("item")) {
        	itemNode = item;
        	break;
        }
        
        Integer page = itemNode.get("subInfo").get("itemPage").intValue();
        String contents = itemNode.get("subInfo").get("toc").textValue();
        String reqAuthor = itemNode.get("subInfo").get("authors").get(0).get("authorName").textValue();
        String authorInfo = itemNode.get("subInfo").get("authors").get(0).get("authorInfo").textValue();
        
        book.updateBookDetail(page, contents, reqAuthor, authorInfo);
        bookRepository.save(book);
    }
    
    // 상세정보가 필요한 경우 알라딘 책 상세정보 api 호출해서 책 상세정보 조회 및 업데이트
    public void updateBookDetailByAladinApi(String isbn) throws JsonMappingException, JsonProcessingException {
    	Book book = bookRepository.findByIsbn(isbn);
    	if(book.getPage() != 0 || !book.getContents().equals("") || !book.getReqAuthor().equals("") || !book.getAuthorInfo().equals("")) {
    		return;
    	}
    	
    	String ttbKey = "ttblyczang41056001";
    	String itemId = isbn;
    	String itemIdType = "ISBN13";
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	String optResult = "authors,Toc";
    	
    	String result = webClient.get()
    	    	.uri(uriBuilder -> uriBuilder
    	    			.path("/ItemLookUp.aspx")
    	    			.queryParam("TTBKey", ttbKey)
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
        
        updateBookDetail(rootNode, book);
    }
    
}

