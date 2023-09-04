package com.ezen.booktving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.booktving.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}
