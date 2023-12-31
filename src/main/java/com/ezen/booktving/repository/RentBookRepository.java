package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ezen.booktving.constant.YesNoStatus;
import com.ezen.booktving.dto.BookTvingTop10Dto;
import com.ezen.booktving.entity.RentBook;

public interface RentBookRepository extends JpaRepository<RentBook, Long>, RentBookRepositoryCustom{
	
	@Query("select r from RentBook r where r.member.userId = :userId order by r.rentDate desc")
	List<RentBook> findRents(@Param("userId") String userId, Pageable pageable);
	
	@Query("select count(r) from RentBook r where r.member.userId = :userId")
	Long countRent(@Param("userId") String userId);
	
	@Query("select r from RentBook r where r.member.userId = :userId")
	List<RentBook> findRentBooksByUserId(@Param("userId") String userId);
	
	@Query("select r from RentBook r where r.member.userId = :userId")
	List<RentBook> findRentByMember(@Param("userId") String userId);
	
	//프로젝션을 이용해 rentBook의 완독 데이터가져오기
	//@Query("select count(r.completeYn) from RentBook r where completeYn = 'Y' and r.member.userId = :userId ")
	List<RentBook> findByCompleteYnAndMember_UserId(YesNoStatus completeYn, String userId);
	
	//프로젝션을 이용해 rentBook의 완독한 갯수 구하기
	long countByCompleteYnAndMember_UserId(YesNoStatus completeYn, String userId);
	
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
		List<BookTvingTop10Dto> getDayBookRankList();
		
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
		List<BookTvingTop10Dto> getWeekBookRankList();
		
		//북티빙 Top10-월간
		@Query(value = "select data.num num, book.book_id id, book.book_name BookName, book_img.img_url imgUrl, book_img.rep_yn repYn, book.publisher publisher, book.isbn isbn, book.author author\r\n"
				+ "			from book"
				+ "		  inner join book_img \r\n"
				+ "			on (book.book_id = book_img.book_id)\r\n"
				+ "		  inner join (select @ROWNUM\\:=@ROWNUM+1 num, groupdata.* \r\n"
				+ "					  from(select rent_book.book_id, YEAR(rent_book.rent_date) rent_year, MONTH(rent_book.rent_date) rent_month, count(*) cnt\r\n"
				+ "						   from rent_book\r\n"
				+ "						   where rent_date >= CURDATE() - INTERVAL 1 MONTH\r\n"
				+ "						   group by rent_book.book_id, YEAR(rent_book.rent_date), MONTH(rent_book.rent_date) order by cnt desc\r\n"
				+ "                           ) groupdata, (SELECT @ROWNUM\\:=0) R limit 7\r\n"
				+ "						) data\r\n"
				+ "			  on (book.book_id = data.book_id)\r\n"
				+ "		  	where book_img.rep_yn = 'Y'\r\n"
				+ "			order by num", nativeQuery = true)
		List<BookTvingTop10Dto> getMonthBookRankList();
		
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
		List<BookTvingTop10Dto> getYearBookRankList();
}
