package com.utilapi.core.facade.impl;

import com.utilapi.core.dto.OTPDTO;
import com.utilapi.core.facade.ICoreOTPCode;
import com.utilapi.persistence.dao.impl.OTPDao;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class CoreOTPCodeImpl implements ICoreOTPCode {

    private OTPDao dao = new OTPDao();

    @Override
    public String generateOTPCode(String username) {
        String otpCode = RandomStringUtils.random(6, true, true);
        OTPDTO otpdto = new OTPDTO(otpCode, username);
        dao.saveCode(otpdto);
        return otpCode;
    }

    @Override
    public List<String> generateOTPCodes(String username) {
        List<String>  otpCodes = new ArrayList<>();
        while(otpCodes.size() < 100){
            otpCodes.add(generateOTPCode(username));
        }
        return otpCodes;
    }

    @Override
    public boolean validateOTPCode(String username, String otpCode) {
        return dao.validateOTPCode(username, otpCode);
    }
}
