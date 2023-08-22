package com.ezen.booktving.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ezen.booktving.entity.Book;
import com.ezen.booktving.entity.FavoriteBook;
import com.ezen.booktving.entity.Member;

public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Long> {
	 List<FavoriteBook> findByMember(Member member);
	 FavoriteBook findByMemberAndBook(Member member, Book book);
	 @Query("select o from FavoriteBook o where o.member = :member order by o.id desc")
	 Page<FavoriteBook> findByMember(@Param("member") Member member, Pageable pageable);
}
