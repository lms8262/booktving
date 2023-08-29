package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeRepositoryCustom {

}
