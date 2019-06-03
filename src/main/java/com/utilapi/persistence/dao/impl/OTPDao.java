package com.utilapi.persistence.dao.impl;

import com.utilapi.core.dto.OTPDTO;

import java.util.List;

public class OTPDao {
    public void saveCode(OTPDTO otpdto) {
        //TODO guardar/update OTP
    }

    public boolean validateOTPCode(String username, String otpCode) {
        //TODO despues de validarlo hacerle update a falso en estado
        return true;
    }

    public boolean saveAllCodes(List<OTPDTO> otpDTOCodes) {
        //TODO save all logic, basarse en UserDAO y UserRepository
/*        Runnable r = new Runnable() {
            public void run() {
                otpRepository.save(buildOTPEntitiesList(otpDTOCodes));
            }
        };
        new Thread(r).start();*/
        return true;
    }
}