package com.ezen.booktving.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ezen.booktving.dto.AuthorSearchDto;
import com.ezen.booktving.entity.Author;
import com.ezen.booktving.entity.AuthorBook;

public interface AuthorRepositoryCustom {

	Page<Author> getAdminAuthorPage(AuthorSearchDto authorSearchDto, Pageable pageable);
	
}
