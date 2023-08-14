package com.ezen.booktving.service;

import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.ezen.booktving.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class ApiService {
	private final BookRepository bookRepository;

    LocalDateTime dateTime = LocalDateTime.now();

    public String getInfo(String result) {

        JSONArray list = null;

        log.info("서비스 시작" );
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        list = (JSONArray) jsonObject.get("results");

        for (int k = 0; k < list.size(); k++) {
        	JSONObject contents = (JSONObject) list.get(k);

            String ImgUrl = "https://image.tmdb.org/t/p/w200";
            String match = "[\"]";

            bookRepository.save(
                    BestSeller.builder()
                            .description(contents.get("overview").toString())
                            .title(contents.get("title").toString())
                            .imgUrl(ImgUrl + contents.get("poster_path").toString().replaceAll(match, ""))
                            .createdAt(dateTime)
                            .modifiedAt(dateTime)
                            .build()
            );

        }
        return "ok";
    }
}
