package com.ezen.booktving.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.BestSeller;

public interface BestSellerRepository extends JpaRepository<BestSeller, Long>, BestSellerRepositoryCustom {

	
}
