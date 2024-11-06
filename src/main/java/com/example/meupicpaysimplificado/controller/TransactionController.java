package com.example.meupicpaysimplificado.controller;

import com.example.meupicpaysimplificado.domain.Transaction;
import com.example.meupicpaysimplificado.domain.TransactionDto;
import com.example.meupicpaysimplificado.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    private ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto dto){
        TransactionDto transactionDto = service.createTransaction(dto);

        return new ResponseEntity<>(transactionDto, HttpStatus.CREATED);
    }

}
