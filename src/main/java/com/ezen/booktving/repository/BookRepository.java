package com.ezen.booktving.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{
	
	Book findByIsbn(String isbn);
}
