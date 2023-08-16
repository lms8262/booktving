package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.NewBookTving;

public interface NewBookTvingRepository extends JpaRepository<NewBookTving, Long>, NewBookTvingRepositoryCustom {

}
