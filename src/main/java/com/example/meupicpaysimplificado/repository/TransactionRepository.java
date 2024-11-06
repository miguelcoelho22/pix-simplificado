package com.example.meupicpaysimplificado.repository;

import com.example.meupicpaysimplificado.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
