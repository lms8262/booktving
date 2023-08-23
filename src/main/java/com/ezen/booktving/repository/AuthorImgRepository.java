package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.AuthorImg;

public interface AuthorImgRepository extends JpaRepository<AuthorImg, Long> {
	
	AuthorImg findByAuthorIdOrderByIdAsc(Long authorId);

}
