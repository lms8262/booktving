package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.BookImg;

public interface BookImgRepository extends JpaRepository<BookImg, Long> {
	
	List<BookImg> findByIdOrderByIdAsc(Long bookId);
	
	//BookImg findByItemIdAndRepimgYn(Long bookId, String repimgYn);
}
