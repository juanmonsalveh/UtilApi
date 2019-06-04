package com.utilapi.core.facade.impl;

import com.utilapi.core.dto.OTPDTO;
import com.utilapi.core.facade.ICoreOTPCode;
import com.utilapi.persistence.dao.facade.IOTPDAO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoreOTPCodeImpl implements ICoreOTPCode {

    private final IOTPDAO otpDao;

    @Autowired
    public CoreOTPCodeImpl(IOTPDAO otpDao) {
        this.otpDao = otpDao;
    }

    @Override
    public String generateOTPCode(String username) {
        String otpCode = RandomStringUtils.random(10, true, true);
        return otpCode;
    }

    @Override
    public List<String> generateOTPCodes(String username) {
        List<String>  otpCodes = new ArrayList<>();
        List<OTPDTO>  otpDTOCodes = new ArrayList<>();
        while(otpCodes.size() < 100){
            String otpCode = generateOTPCode(username);
            otpCodes.add(otpCode);
            OTPDTO otpdto = new OTPDTO(otpCode, username);
            otpDTOCodes.add(otpdto);
        }
        otpDao.saveOtps(otpDTOCodes);
        return otpCodes;
    }

    @Override
    public boolean validateOTPCode(String username, String code) {
        OTPDTO otpCode = otpDao.getOTPCode(username, code);
        boolean response = otpCode.isActive();
        updateOtp(otpCode, response);
        return response;
    }

    private void updateOtp(OTPDTO otpCode, boolean response) {
        if (response) {
            otpCode.setActive(false);
            otpDao.updateOtpCode(otpCode);
        }
    }
}
