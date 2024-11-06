package com.example.meupicpaysimplificado.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UserDto(
        @NotNull
        String name,
        @NotNull
        String telefone,
        @NotNull
        String email,
        @NotNull
        UserType userType,
        @NotNull
        BigDecimal balance) {
        public UserDto(User user) {
                this(user.getName(), user.getTelefone(), user.getEmail(), user.getUserType(), user.getBalance());
        }
}
