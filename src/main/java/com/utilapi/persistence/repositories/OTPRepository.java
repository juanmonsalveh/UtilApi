package com.utilapi.persistence.repositories;

import com.utilapi.persistence.entity.OTPEntity;
import org.springframework.data.repository.CrudRepository;

public interface OTPRepository extends CrudRepository<OTPEntity, String> {

    OTPEntity findByOwnerAndOtpCode(String owner, String otpCode);
}
