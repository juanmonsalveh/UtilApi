package com.utilapi.core.facade;

import com.utilapi.core.dto.OTPDTO;

import java.util.List;

public interface ICoreOTPCode {
    String generateOTPCode(String username);
    List<String> generateOTPCodes(String username);
    boolean validateOTPCode(String username, String otpCode);
}
