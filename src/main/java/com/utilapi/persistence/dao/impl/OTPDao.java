package com.utilapi.persistence.dao.impl;

import com.utilapi.core.dto.OTPDTO;

public class OTPDao {
    public void saveCode(OTPDTO otpdto) {
    }

    public boolean validateOTPCode(String username, String otpCode) {
        //validate, update as false to BDD
        return true;
    }
}