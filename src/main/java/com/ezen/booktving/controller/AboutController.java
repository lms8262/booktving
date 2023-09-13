package com.ezen.booktving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AboutController {

	@GetMapping(value = "/about/project")
	public String aboutPage(Model model) {
		
		
		return "about/aboutProject";
	}
	
}
