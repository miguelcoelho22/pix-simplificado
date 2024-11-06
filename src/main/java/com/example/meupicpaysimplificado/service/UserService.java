package com.example.meupicpaysimplificado.service;

import com.example.meupicpaysimplificado.domain.EmailDto;
import com.example.meupicpaysimplificado.domain.User;
import com.example.meupicpaysimplificado.domain.UserDto;
import com.example.meupicpaysimplificado.domain.UserType;
import com.example.meupicpaysimplificado.exception.TransactionException;
import com.example.meupicpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public UserDto createUser(UserDto dto) {
        User user = new User(dto);
        repository.save(user);
        return new UserDto(user);
    }

    public List<UserDto> findAll() {
        return repository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public void validateTransaction(User sender, BigDecimal amount){
        if(sender.getUserType() == UserType.LOJISTA){
            throw new TransactionException("lojistas nao podem enviar");
        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new TransactionException("saldo insuficiente para envio");
        }

    }


}
