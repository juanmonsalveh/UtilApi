package com.utilapi.core.facade.impl;

import com.utilapi.application.UtilApiApplication;
import com.utilapi.core.facade.ICoreEmail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UtilApiApplication.class)
public class CoreEmailImplTest {

    private ICoreEmail mailsender;

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.username}") String fromEmail;
    private String toEmail;
    @Before
    public void setUp() throws Exception {
        mailsender = new CoreEmailImpl();
        fromEmail = "Easybank.2019@gmail.com";
        toEmail = "juanmonsalveh@gmail.com";
    }

    @Test
    public void sendEmail() throws UnsupportedEncodingException {
        // mailsender.sendEmail();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject("Asunto");
        message.setText("texto");
        emailSender.send(message);
    }
}