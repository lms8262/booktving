package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.NewBookTving;

public interface NewBookTvingRepository extends JpaRepository<NewBookTving, Long>, NewBookTvingRepositoryCustom {

	List<NewBookTving> findAll();
}
