package com.ezen.booktving.service;

import org.springframework.stereotype.Service;


@Service
public class ApiService {

	/*private final BookRepository bookRepository;
=======
	private final BestSellerRepository bestSellerRepository;
>>>>>>> 6b6b566495e6435166a315181c1b014c688d61f0

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
    }*/
}
