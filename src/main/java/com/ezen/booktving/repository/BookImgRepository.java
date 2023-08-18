package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.entity.BookImg;

public interface BookImgRepository extends JpaRepository<BookImg, Long>{
	
	//select * from book_img where book_id=? order by book_id ASC;
	List<BookImg> findByBookIdOrderByIdAsc(Long bookId);
	
	//select * from book_img where book_id = ? and rep_yn = ?
	BookImg findByBookIdAndRepYn(Long bookId, YesNoStatus repYn);

}
