package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.AuthorBook;

public interface AuthorBookRepository extends JpaRepository<AuthorBook, Long> {

}
