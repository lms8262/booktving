package com.ezen.booktving.service;

import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.ezen.booktving.entity.BestSeller;
import com.ezen.booktving.repository.BestSellerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class ApiService {

	

	private final BestSellerRepository bestSellerRepository;

    LocalDateTime dateTime = LocalDateTime.now();

    public String getInfo(String result) throws ParseException {

        JSONArray list = null;
        
        log.info("서비스 시작" );
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
}