package com.utilapi.core.facade.impl;

import com.utilapi.core.facade.ICoreEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreEmailImpl implements ICoreEmail {

    @Autowired
    public JavaMailSender emailSender;

     //@Value("${spring.mail.username}") String fromEmail;

    @Override
    public void sendEmail(String fromEmail,String sendTo, String subject, String textMessage) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(sendTo);
            message.setSubject(subject);
            message.setText(textMessage);
            emailSender.send(message);
    }

    @Override
    public String buildOTPListMailBody(String bankUser, List<String> otpCodes) {
        String message = "Welcome " + bankUser + ",\n\n" +
                "These are the OTP Codes you will be using to authenticate your transactions:\n\n";

        for (int i=0; i<otpCodes.size();i++) {
            message = ((i+1)%5==0) ?
                    message.concat(otpCodes.get(i)).concat("\n"):
                    message.concat(otpCodes.get(i)).concat(",\t ");
        }
        message = message.concat("\nPlease be careful with those codes\nRegards.");

        return message;
    }
}
