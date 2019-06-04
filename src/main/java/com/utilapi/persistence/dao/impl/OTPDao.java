package com.utilapi.persistence.dao.impl;

import com.utilapi.core.dto.OTPDTO;
import com.utilapi.persistence.dao.facade.IOTPDAO;
import com.utilapi.persistence.entity.OTPEntity;
import com.utilapi.persistence.repositories.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OTPDao implements IOTPDAO {

    private final OTPRepository otpRepository;

    @Autowired
    public OTPDao(OTPRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    @Override
    public boolean saveOtps(List<OTPDTO> otpdtoList) {
        List<OTPEntity> otpEntities = otpdtoList.stream().map(this::mapToOtpEntity).collect(Collectors.toList());
        return otpRepository.saveAll(otpEntities).iterator().hasNext();
    }

    @Override
    public OTPDTO getOTPCode(String username, String code) {
        return mapToOtpDTO(
                otpRepository.findByOwnerAndOtpCode(username, code)
        );
    }

    @Override
    public boolean updateOtpCode(OTPDTO otpdto) {
        otpRepository.save(mapToOtpEntity(otpdto));
        return true;
    }

    private OTPEntity mapToOtpEntity(OTPDTO otpdto){
        OTPEntity otpEntity = new OTPEntity();
        otpEntity.setActive(otpdto.isActive());
        otpEntity.setOtpCode(otpdto.getOtpCode());
        otpEntity.setOwner(otpdto.getOwner());
        return otpEntity;
    }

    private OTPDTO mapToOtpDTO(OTPEntity otpEntity){
        OTPDTO otpdto = new OTPDTO();
        otpdto.setActive(otpEntity.isActive());
        otpdto.setOtpCode(otpEntity.getOtpCode());
        otpdto.setOwner(otpEntity.getOwner());
        return otpdto;
    }
}