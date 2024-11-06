package com.example.meupicpaysimplificado.domain;

import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public record TransactionDto(Long sender, Long receiver, BigDecimal value) {
    public TransactionDto(Transaction transaction) {
        this(transaction.getSender().getId(), transaction.getReceiver().getId(), transaction.getBalance());
    }
}
