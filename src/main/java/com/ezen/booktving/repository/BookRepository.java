package com.ezen.booktving.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ezen.booktving.dto.BookTvingTop10Dto;
import com.ezen.booktving.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{
	
	Book findByIsbn(String isbn);

	List<Book> findByBookName(String bookName);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByRegTimeAfter(LocalDateTime regTime);


}
