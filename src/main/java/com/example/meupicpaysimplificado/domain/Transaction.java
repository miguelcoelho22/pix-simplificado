package com.example.meupicpaysimplificado.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private BigDecimal balance;

    private LocalDateTime time;
    public Transaction(User sender, User receiver, TransactionDto dto) {
        this.sender = sender;
        this.receiver = receiver;
        this.balance = dto.value();
        this.time = LocalDateTime.now();
    }
}
