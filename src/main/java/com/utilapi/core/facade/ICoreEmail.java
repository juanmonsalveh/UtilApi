package com.utilapi.core.facade;

public interface ICoreEmail {
    void sendEmail(String sendTo, String subject, String textMessage);
}
