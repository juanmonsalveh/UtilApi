package com.utilapi.core.dto;

import com.utilapi.controller.exception.ApiException;
import com.utilapi.util.Validator;
import okhttp3.internal.http2.ErrorCode;

import java.util.Objects;

public class UserDTO {
    private String name;
    private String username;
    private String password;
    private String email;
    private String identity;
    private boolean isBankEmployee;

    public UserDTO() {
    }

    public UserDTO(String name, String username, String password, String email, String identity, boolean isBankEmployee) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.identity = identity;
        this.isBankEmployee = isBankEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public boolean isBankEmployee() {
        return isBankEmployee;
    }

    public void setBankEmployee(boolean bankEmployee) {
        isBankEmployee = bankEmployee;
    }

    public static boolean validateAttributes(UserDTO userDTO) throws ApiException {
        Validator validator = new Validator();
        boolean validation = true;
        validation = (  validation && Objects.nonNull(userDTO)
                        && validator.validateEmail(userDTO.getEmail())
                        && validator.validateAlpha(userDTO.getName())
                        && validator.validateAlpha(userDTO.getUsername())
                        && validator.validateNumeric(userDTO.getIdentity())
                        && validator.validatePassword(userDTO.getPassword())  );
        if (!validation ) throw new ApiException("Error, wrong parameters...", ErrorCode.INTERNAL_ERROR);
        return validation;
    }
}
