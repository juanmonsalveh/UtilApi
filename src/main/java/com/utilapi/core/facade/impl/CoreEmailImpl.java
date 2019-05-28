package com.utilapi.core.facade.impl;

import com.utilapi.core.facade.ICoreEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class CoreEmailImpl implements ICoreEmail {

    @Autowired
    public JavaMailSender emailSender;

    //    @Value("${spring.mail.username}") String fromEmail;
     String fromEmail = "Easybank.2019@gmail.com";

    @Override
    public void sendEmail() {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo("juanmonsalveh@gmail.com");
            message.setSubject("Asunto");
            message.setText("texto");
            emailSender.send(message);
    }
}
