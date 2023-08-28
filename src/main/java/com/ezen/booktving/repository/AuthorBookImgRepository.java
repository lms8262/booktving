package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.AuthorBookImg;

public interface AuthorBookImgRepository extends JpaRepository<AuthorBookImg, Long>{
	
	AuthorBookImg findByAuthorBookIdOrderByIdAsc(Long authorBookId);

}
