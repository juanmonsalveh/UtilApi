package com.utilapi.core.facade.impl;

import com.utilapi.core.facade.ICoreEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CoreEmailImpl implements ICoreEmail {

    @Autowired
    public JavaMailSender emailSender;

     @Value("${spring.mail.username}") String fromEmail;

    @Override
    public void sendEmail(String sendTo, String subject, String textMessage) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(sendTo);
            message.setSubject(subject);
            message.setText(textMessage);
            emailSender.send(message);
    }
}
