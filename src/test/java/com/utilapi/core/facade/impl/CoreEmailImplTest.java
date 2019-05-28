package com.utilapi.core.facade.impl;

import com.utilapi.application.UtilApiApplication;
import com.utilapi.core.facade.ICoreEmail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UtilApiApplication.class)
public class CoreEmailImplTest {

    @Autowired
    private ICoreEmail mailsender;

    @Autowired
    public JavaMailSender emailSender;

    private String sendTo;

    @Before
    public void setUp() {
        sendTo = "juanmonsalveh@gmail.com";
    }

    @Test
    public void sendEmail() throws Exception{
        String subject = "Test subject - " + new Date();
        String messageText = "Message text :)";
         mailsender.sendEmail(sendTo, subject, messageText);
    }
}