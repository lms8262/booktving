package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.AuthorBook;
import com.ezen.booktving.entity.AuthorImg;

public interface AuthorBookRepository extends JpaRepository<AuthorBook, Long> {
	
	List<AuthorBook> findByAuthorIdOrderByIdAsc(Long authorId);

}
