package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ezen.booktving.entity.RentBook;

public interface RentRepository extends JpaRepository<RentBook, Long>{
	
	@Query("select r from RentBook r where r.member.userId = :userId order by r.rentDate desc")
	List<RentBook> findRents(@Param("userId") String userId, Pageable pageable);
	
	@Query("select count(r) from RentBook r where r.member.userId = :userId")
	Long countRent(@Param("userId") String userId);
	
	@Query("select r from RentBook r where r.member.userId = :userId")
	List<RentBook> findRentByMember(@Param("userId") String userId);
}
