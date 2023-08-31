package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ezen.booktving.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeRepositoryCustom {
	
	@Query(value = "select * from notice", nativeQuery = true )
	List<Notice> getMainNoticePage();
}
