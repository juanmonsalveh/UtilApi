package com.utilapi.core.dto;

public class OTPDTO {
    private String otpCode;
    private String owner;
    private boolean isActive;

    public OTPDTO(){}

    public OTPDTO(String otpCode, String owner){
        this.otpCode = otpCode;
        this.owner = owner;
        this.isActive = true;
    }

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
