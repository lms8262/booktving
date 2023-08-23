package com.ezen.booktving.service;

import org.springframework.stereotype.Service;

@Service
public interface IdService {

	public String finduserId(String memberName, String email);
	/* public String findId(String memberName, String email); */

}
