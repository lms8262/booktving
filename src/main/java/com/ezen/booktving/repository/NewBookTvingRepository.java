package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ezen.booktving.entity.NewBookTving;

public interface NewBookTvingRepository extends JpaRepository<NewBookTving, Long>, NewBookTvingRepositoryCustom {

	//스케줄러 이용시 api 중복 저장 되지 않게 하려고 isbn 이용하기 
	@Query("select n.isbn from NewBookTving n")
	List<String> findAllIsbn();
}
