package com.utilapi.core.facade.impl;

import com.utilapi.application.UtilApiApplication;
import com.utilapi.core.facade.ICoreEmail;
import com.utilapi.core.facade.ICoreOTPCode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UtilApiApplication.class)
public class CoreEmailImplTest {

    @Autowired
    private ICoreEmail mailsender;

    @Autowired
    public JavaMailSender emailSender;

    private String sendTo;
    private String sendFrom;

    @Before
    public void setUp() {
        sendTo = "juanmonsalveh@gmail.com";
        sendFrom = System.getProperty("spring.mail.username", "Easybank.2019@gmail.com");
    }

    @Test
    public void sendEmail() throws Exception{
        String subject = "Test subject - " + new Date();
        String messageText = "Message text :)";
        mailsender.sendEmail(sendFrom, sendTo, subject, messageText);
    }
    @Test
    public void send100OTPsByEmail() throws Exception{
        ICoreOTPCode otpCore = new CoreOTPCodeImpl();
        String bankUser = "Any User";
        String subject = "Test subject - " + new Date();
        List<String> otpCodes = otpCore.generateOTPCodes(bankUser);
        ICoreEmail mailCore = new CoreEmailImpl();
        String mailBody = mailCore.buildOTPListMailBody(bankUser, otpCodes);
        mailsender.sendEmail(sendFrom, sendTo,subject,mailBody);
    }
}