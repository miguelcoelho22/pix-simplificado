package com.example.meupicpaysimplificado.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String telefone;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private BigDecimal balance;

    public User(UserDto dto) {
        this.name = dto.name();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.userType = dto.userType();
        this.balance = dto.balance();
    }
}
