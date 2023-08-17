package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

	List<BookReview> findByIdOrderByIdAsc(Long reviewId);
	
}
