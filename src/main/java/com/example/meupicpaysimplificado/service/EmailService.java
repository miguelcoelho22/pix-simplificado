package com.example.meupicpaysimplificado.service;

import com.example.meupicpaysimplificado.domain.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void SendEmail(EmailDto emailDto){
        var email = new SimpleMailMessage();
        email.setFrom("miguelarthurmeumine@gmail.com");
        email.setSubject(emailDto.subject());
        email.setTo(emailDto.to());
        email.setText(emailDto.text());
        javaMailSender.send(email);
    }


}
