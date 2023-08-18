package com.ezen.booktving.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{
	
	List<Book> findByBookName(String bookName);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByRegTimeAfter(LocalDateTime regTime);

}
