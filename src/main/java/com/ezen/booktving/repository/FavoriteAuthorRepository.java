package com.ezen.booktving.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ezen.booktving.dto.FavoriteAuthorDto;
import com.ezen.booktving.entity.FavoriteAuthor;

public interface FavoriteAuthorRepository extends JpaRepository<FavoriteAuthor, Long>{

	@Query(value = "select data.num num, author.author_id authorId, author.author_name_ko authorName, author_img.img_url authorImg\r\n"
			+ "				from author "
			+ "			inner join author_img \r\n"
			+ "				on (author.author_id = author_img.author_id)\r\n"
			+ "		  	inner join (select @ROWNUM:=@ROWNUM+1 num, groupdata.* \r\n"
			+ "					    from(select favorite_author.member_id, favorite_author.author_id, MAX(favorite_author.reg_time) favoriteTime, count(*) cnt\r\n"
			+ "						     from favorite_author\r\n"
			+ "						     where favorite_author.member_id = :userId\r\n"
			+ "						     group by favorite_author.author_id order by favoriteTime desc\r\n"
			+ "                          ) groupdata, (SELECT @ROWNUM:=0) R limit 5\r\n"
			+ "						) data\r\n"
			+ "			  	on (author.author_id = data.author_id)\r\n"
			+ "		  	order by num", nativeQuery = true )
	Page<FavoriteAuthorDto> findFavoriteAuthor(@Param("userId") String userId, Pageable pageable);
	
	@Query(value = "select count(*) from favorite_author where member_id= :userId order by reg_time", nativeQuery = true)
	Long countFavoriteAuthor(@Param("userId") String userId);
	
}
