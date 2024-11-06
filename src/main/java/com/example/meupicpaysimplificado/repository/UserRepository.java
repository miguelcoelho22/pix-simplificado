package com.example.meupicpaysimplificado.repository;

import com.example.meupicpaysimplificado.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
