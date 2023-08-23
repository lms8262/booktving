package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>,  AuthorRepositoryCustom{

}
