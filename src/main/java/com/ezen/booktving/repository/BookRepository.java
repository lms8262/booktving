package com.ezen.booktving.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ezen.booktving.dto.BookTvingTop10Dto;
import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.FavoriteBook;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{
	
	Book findByIsbn(String isbn);

	List<Book> findByBookName(String bookName);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByRegTimeAfter(LocalDateTime regTime);
	
	@Query("select f from FavoriteBook f where f.member.userId = :userId")
	List<FavoriteBook> findByMember(@Param("userId") String userId);

	@Query("select f from FavoriteBook f where f.member.userId = :userId")
	List<FavoriteBook> findFavoritebook(@Param("userId") String userId, Pageable pageable);
	
	@Query("select count(f) from FavoriteBook f where f.member.userId = :userId")
	Long countFavoriteBook(@Param("userId") String userId);

}
