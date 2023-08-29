package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Book;

public interface BookDetailRepository extends JpaRepository<Book, Long>{

	Book findByIsbnOrderByIdAsc(String isbn);
	Book findByIsbn(String isbn);
}