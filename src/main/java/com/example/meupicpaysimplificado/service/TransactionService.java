package com.example.meupicpaysimplificado.service;

import com.example.meupicpaysimplificado.domain.*;
import com.example.meupicpaysimplificado.repository.TransactionRepository;
import com.example.meupicpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService service;

    @Autowired
    private EmailService emailService;


    public TransactionDto createTransaction(TransactionDto dto) {
        User sender = userRepository.findById(dto.sender()).get();
        User receiver = userRepository.findById(dto.receiver()).get();

        service.validateTransaction(sender, dto.value());

        Transaction transaction = new Transaction(sender, receiver, dto);


        sender.setBalance(sender.getBalance().subtract(dto.value()));
        receiver.setBalance(receiver.getBalance().add(dto.value()));

        repository.save(transaction);
        userRepository.save(sender);
        userRepository.save(receiver);

        EmailDto emailDto = new EmailDto(sender.getEmail(), "movimentacao na conta", "foi feito uma transaçao no valor de " + dto.value() + "para" + receiver.getName());
        emailService.SendEmail(emailDto);

        return new TransactionDto(transaction);
    }
}
