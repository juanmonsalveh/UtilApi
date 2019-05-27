package com.utilapi.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "OTP")
public class OTPEntity {

    @Id
    @Column(name = "otp_code", nullable = false)
    private String otpCode;

    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}