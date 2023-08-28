package com.ezen.booktving.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ezen.booktving.dto.BookTvingTop10Dto;
import com.ezen.booktving.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{
	
	Book findByIsbn(String isbn);

	List<Book> findByBookName(String bookName);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByRegTimeAfter(LocalDateTime regTime);

	
	//북티빙 Top10-일간
	@Query(value = "select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author\r\n"
			+ "			from book "
			+ "		  inner join book_img \r\n"
			+ "			on (book.book_id = book_img.book_id)\r\n"
			+ "		  inner join (select @ROWNUM\\:=@ROWNUM+1 num, groupdata.* \r\n"
			+ "					  from(select rent_book.book_id, DATE(rent_book.rent_date) rent_date, count(*) cnt\r\n"
			+ "						   from rent_book\r\n"
			+ "						   where rent_date >= CURDATE() - INTERVAL 1 DAY\r\n"
			+ "						   group by rent_book.book_id, DATE(rent_book.rent_date) order by cnt desc\r\n"
			+ "                           ) groupdata, (SELECT @ROWNUM\\:=0) R limit 7\r\n"
			+ "						) data\r\n"
			+ "			  on (book.book_id = data.book_id)\r\n"
			+ "		  	where book_img.rep_yn = 'Y'\r\n"
			+ "			order by num", nativeQuery = true)
	Page<BookTvingTop10Dto> getDayBookRankList(Pageable pageable);
	
	//북티빙 Top10-주간
	@Query(value = "select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author\r\n"
			+ "			from book "
			+ "		  inner join book_img \r\n"
			+ "			on (book.book_id = book_img.book_id)\r\n"
			+ "		  inner join (select @ROWNUM\\:=@ROWNUM+1 num, groupdata.* \r\n"
			+ "					  from(select rent_book.book_id, YEAR(rent_book.rent_date) rent_year, WEEK(rent_book.rent_date) rent_week, count(*) cnt\r\n"
			+ "						   from rent_book\r\n"
			+ "						   where rent_date >= CURDATE() - INTERVAL 1 WEEK\r\n"
			+ "						   group by rent_book.book_id, YEAR(rent_book.rent_date), WEEK(rent_book.rent_date) order by cnt desc\r\n"
			+ "                           ) groupdata, (SELECT @ROWNUM\\:=0) R limit 7\r\n"
			+ "						) data\r\n"
			+ "			  on (book.book_id = data.book_id)\r\n"
			+ "		  	where book_img.rep_yn = 'Y'\r\n"
			+ "			order by num", nativeQuery = true)
	Page<BookTvingTop10Dto> getWeekBookRankList(Pageable pageable);
	
	//북티빙 Top10-월간
	@Query(value = "select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author\r\n"
			+ "			from book"
			+ "		  inner join book_img \r\n"
			+ "			on (book.book_id = book_img.book_id)\r\n"
			+ "		  inner join (select @ROWNUM\\:=@ROWNUM+1 num, groupdata.* \r\n"
			+ "					  from(select rent_book.book_id, YEAR(rent_book.rent_date) rent_year, MONTH(rent_book.rent_date) rent_month, count(*) cnt\r\n"
			+ "						   from rent_book\r\n"
			+ "						   where rent_date >= CURDATE() - INTERVAL 1 YEAR\r\n"
			+ "						   group by rent_book.book_id, YEAR(rent_book.rent_date), MONTH(rent_book.rent_date) order by cnt desc\r\n"
			+ "                           ) groupdata, (SELECT @ROWNUM\\:=0) R limit 7\r\n"
			+ "						) data\r\n"
			+ "			  on (book.book_id = data.book_id)\r\n"
			+ "		  	where book_img.rep_yn = 'Y'\r\n"
			+ "			order by num", nativeQuery = true)
	Page<BookTvingTop10Dto> getMonthBookRankList(Pageable pageable);
	
	//북티빙 Top10-연간
	@Query(value = "select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author\r\n"
			+ "			from book "
			+ "		  inner join book_img \r\n"
			+ "			on (book.book_id = book_img.book_id)\r\n"
			+ "		  inner join (select @ROWNUM\\:=@ROWNUM+1 num, groupdata.* \r\n"
			+ "					  from(select rent_book.book_id, YEAR(rent_book.rent_date) rent_year, count(*) cnt\r\n"
			+ "						   from rent_book\r\n"
			+ "						   where rent_date >= CURDATE() - INTERVAL 1 YEAR\r\n"
			+ "						   group by rent_book.book_id, YEAR(rent_book.rent_date) order by cnt desc\r\n"
			+ "                           ) groupdata, (SELECT @ROWNUM\\:=0) R limit 7\r\n"
			+ "						) data\r\n"
			+ "			  on (book.book_id = data.book_id)\r\n"
			+ "		  	where book_img.rep_yn = 'Y'\r\n"
			+ "			order by num", nativeQuery = true)
	Page<BookTvingTop10Dto> getYearBookRankList(Pageable pageable);

}
