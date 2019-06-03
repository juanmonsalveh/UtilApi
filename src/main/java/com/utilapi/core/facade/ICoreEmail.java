package com.utilapi.core.facade;

import java.util.List;

public interface ICoreEmail {
    void sendEmail(String mailFrom, String sendTo, String subject, String textMessage);
    String buildOTPListMailBody(String bankUser, List<String> otpCodes);
}
