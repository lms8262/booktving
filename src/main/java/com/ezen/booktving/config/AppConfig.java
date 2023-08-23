package com.ezen.booktving.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ezen.booktving.dto.AuthorFormDto;
import com.ezen.booktving.entity.AuthorBook;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modelMapper () {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<AuthorFormDto, AuthorBook>() {

			@Override
			protected void configure() {
				skip(destination.getAuthor());
			}
			
		});
		return modelMapper;
	}
	
}
