package com.utilapi.persistence.dao.facade;


import com.utilapi.core.dto.OTPDTO;

import java.util.List;

public interface IOTPDAO {

    boolean saveOtps(List<OTPDTO> otpdtoList);
    OTPDTO getOTPCode(String username, String code);
    boolean updateOtpCode(OTPDTO otpdto);
}