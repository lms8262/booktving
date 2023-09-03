package com.ezen.booktving.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.BookSearchDto;
import com.ezen.booktving.dto.CategoryResultDto;
import com.ezen.booktving.dto.SearchBookDto;
import com.ezen.booktving.dto.SearchResultDto;
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
        	
        	String isbn = !contents.get("isbn13").toString().equals("") ? contents.get("isbn13").toString() : contents.get("isbn").toString();
        	
        	String aladinApiAuthor = contents.get("author").toString();
            String processedAuthor = extractAuthorName(aladinApiAuthor);
        	
            bestSellerRepository.save(
                    BestSeller.builder()
                            .title(contents.get("title").toString())
                            .isbn(isbn)
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
    public void getNewBookTving(String result) throws ParseException, IOException {
    	
    	JSONArray list = null;
    	
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jSONObject = (JSONObject)jsonParser.parse(result) ;
    	list = (JSONArray) jSONObject.get("item");
    	
    	for(int k = 0; k < list.size(); k++) {
    		JSONObject contents = (JSONObject) list.get(k);
    		
    		String isbn = !contents.get("isbn13").toString().equals("") ? contents.get("isbn13").toString() : contents.get("isbn").toString();
    		
    		String aladinApiAuthor = contents.get("author").toString();
    		String processedAuthor = extractAuthorName(aladinApiAuthor);
    		
    		newBookTvingRepository.save(
    				NewBookTving.builder()
    							.title(contents.get("title").toString())
    							.isbn(isbn)
    							.author(processedAuthor)
    							.publisher(contents.get("publisher").toString())
    							.imgUrl(contents.get("cover").toString())
    							.link(contents.get("link").toString())
    							.build()
    		
    		);
    		saveBookInfo(isbn);
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
    
    // 검색 api 결과가 들어있는 jsonString
    private String getJsonStringOfSearchBook(BookSearchDto bookSearchDto, int start) {
    	String ttbKey = "ttblyczang41056001";
    	String query = bookSearchDto.getSearchQuery();
    	String queryType = bookSearchDto.getSearchBy();
    	int maxResults = 48;
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	
		String jsonString = webClient.get()
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
		
		return jsonString;
    }
    
    // 검색 api 호출해서 가져온 검색결과 JsonNode로 검색결과 List 생성
    private List<SearchBookDto> generateItemsOfSearchResult(JsonNode rootNode) {
    	List<SearchBookDto> items = new ArrayList<>();
    	for(JsonNode itemNode : rootNode.get("item")) {
    		String bookName = itemNode.get("title").textValue();
    		// isbn13이 공백이 아니면 isbn13, 공백이면 isbn을 사용
    		String isbn = !itemNode.get("isbn13").textValue().equals("") ? itemNode.get("isbn13").textValue() : itemNode.get("isbn").textValue();
    		String author = itemNode.get("author").textValue();
    		String imgUrl = itemNode.get("cover").textValue();
    		
    		SearchBookDto searchBookDto = SearchBookDto.builder()
    												   .bookName(bookName)
    												   .isbn(isbn)
    												   .author(author)
    												   .imgUrl(imgUrl)
    												   .build();
    		items.add(searchBookDto);
    	}
    	return items;
    }
    
    // 알라딘 검색 api를 호출해서 보여줄 검색 결과
    public SearchResultDto getSearchResultByAladinApi(BookSearchDto bookSearchDto, int currentPage) throws JsonMappingException, JsonProcessingException {
    	currentPage++; // 현재 페이지를 1 증가시킴
    	String jsonString = getJsonStringOfSearchBook(bookSearchDto, currentPage);
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);
        
        int totalResults = rootNode.get("totalResults").intValue();
        int totalItems = totalResults > 240 ? 240 : totalResults; // 240 = 48 * 5
        int itemsPerPage = rootNode.get("itemsPerPage").intValue();
        boolean last = totalItems - (currentPage * itemsPerPage) <= 0 ? true : false;
        List<SearchBookDto> items = generateItemsOfSearchResult(rootNode);
    	
        SearchResultDto searchResultDto = SearchResultDto.builder()
        												 .bookSearchDto(bookSearchDto)
        												 .totalItems(totalItems)
        												 .currentPage(currentPage)
        												 .itemsPerPage(itemsPerPage)
        												 .last(last)
        												 .items(items)
        												 .build();
    	return searchResultDto;
    }
    
    // 책 상세정보가 들어있는 jsonString
    private String getJsonStringOfBookDetail(String isbn) {
    	String ttbKey = "ttblyczang41056001";
    	String itemId = isbn;
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	String optResult = "authors,Toc";
    	
    	String jsonString = webClient.get()
    	    	.uri(uriBuilder -> uriBuilder
    	    			.path("/ItemLookUp.aspx")
    	    			.queryParam("TTBKey", ttbKey)
    	    			.queryParam("ItemId", itemId)
    	    			.queryParam("Cover", cover)
    	    			.queryParam("Output", output)
    	    			.queryParam("Version", version)
    	    			.queryParam("OptResult", optResult)
    	    			.build()
    	    		)
    	    	.retrieve()
    	    	.bodyToMono(String.class)
    	    	.block();
    	
    	return jsonString;
    }
    
    // 상세정보 api 호출해서 가져온 JsonNode로 상세정보와 이미지 저장
    private void saveBookAndBookImg(JsonNode rootNode) throws IOException {
    	JsonNode itemNode = null;
        
        // 1번째 item만 꺼내오기
        for(JsonNode item : rootNode.get("item")) {
        	itemNode = item;
        	break;
        }
        
        String bookName = itemNode.get("title").textValue();
        String isbn = !itemNode.get("isbn13").textValue().equals("") ? itemNode.get("isbn13").textValue() : itemNode.get("isbn").textValue();
        String author = itemNode.get("subInfo").get("authors").get(0).get("authorName").textValue();
        String publisher = itemNode.get("publisher").textValue();
        LocalDate publicationDate = LocalDate.parse(itemNode.get("pubDate").textValue(), DateTimeFormatter.ISO_DATE);
        String bookIntroduction = itemNode.get("description").textValue();
        String category = itemNode.get("categoryName").textValue();
        Integer page = itemNode.get("subInfo").get("itemPage").intValue();
        String contents = itemNode.get("subInfo").get("toc").textValue();
        String authorInfo = itemNode.get("subInfo").get("authors").get(0).get("authorInfo").textValue();
        
        Book book = Book.builder()
    			.bookName(bookName)
        		.isbn(isbn)
        		.author(author)
        		.publisher(publisher)
        		.publicationDate(publicationDate)
        		.bookIntroduction(bookIntroduction)
        		.category(category)
        		.page(page)
        		.contents(contents)
        		.authorInfo(authorInfo)
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
    
    // 책 상세정보가 필요할 시 api 호출해서 책 정보 저장
    public void saveBookInfo(String isbn) throws IOException {
    	Book findBook = bookRepository.findByIsbn(isbn);
    	if(findBook != null) { // 이미 db에 저장돼있으면 리턴
    		return;
    	}
    	
    	String jsonString = getJsonStringOfBookDetail(isbn);
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);
        
        saveBookAndBookImg(rootNode);
    }
    
    // 카테고리 검색 api 결과가 들어있는 jsonString 
    private String getJsonStringOfCategoryBook(int categoryId, int start) {
    	String ttbKey = "ttblyczang41056001";
    	String queryType = "ItemNewAll";
    	int maxResults = 48;
    	String cover = "Big";
    	String output = "JS";
    	String version = "20131101";
    	
		String jsonString = webClient.get()
		    	.uri(uriBuilder -> uriBuilder
		    			.path("/ItemList.aspx")
		    			.queryParam("TTBKey", ttbKey)
		    			.queryParam("QueryType", queryType)
		    			.queryParam("Start", start)
		    			.queryParam("MaxResults", maxResults)
		    			.queryParam("Cover", cover)
		    			.queryParam("Output", output)
		    			.queryParam("Version", version)
		    			.queryParam("CategoryId", categoryId)
		    			.build()
		    		)
		    	.retrieve()
		    	.bodyToMono(String.class)
		    	.block();
		
		return jsonString;
    }
    
    // 알라딘 카테고리 검색 api를 호출해서 보여줄 카테고리 검색 결과
    public CategoryResultDto getCategoryResultByAladinApi(int categoryId, int currentPage) throws JsonMappingException, JsonProcessingException {
    	currentPage++; // 현재 페이지를 1 증가시킴
    	String jsonString = getJsonStringOfCategoryBook(categoryId, currentPage);
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);
        
        int totalResults = rootNode.get("totalResults").intValue();
        int totalItems = totalResults > 240 ? 240 : totalResults; // 240 = 48 * 5
        int itemsPerPage = rootNode.get("itemsPerPage").intValue();
        boolean last = totalItems - (currentPage * itemsPerPage) <= 0 ? true : false;
        List<SearchBookDto> items = generateItemsOfSearchResult(rootNode);
    	
        CategoryResultDto categoryResultDto = CategoryResultDto.builder()
        												 .categoryId(categoryId)
        												 .totalItems(totalItems)
        												 .currentPage(currentPage)
        												 .itemsPerPage(itemsPerPage)
        												 .last(last)
        												 .items(items)
        												 .build();
    	return categoryResultDto;
    }

}

