package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.MemberCommutation;

public interface MemberCommutationRepository extends JpaRepository<MemberCommutation, Long>, MemberCommutationRepositoryCustom {

}
