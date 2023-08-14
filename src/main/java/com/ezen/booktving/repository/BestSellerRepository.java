package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.BestSeller;

public interface BestSellerRepository extends JpaRepository<BestSeller, Long> {

	List<BestSeller> findByTitle(String title);
}
