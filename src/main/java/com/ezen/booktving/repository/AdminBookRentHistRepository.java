package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.RentBook;

public interface AdminBookRentHistRepository extends JpaRepository<RentBook, Long>, AdminBookRentListRepositoryCustom{
	
	List<RentBook> findByReview(String review);
}
