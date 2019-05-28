package com.utilapi.core.facade.impl;

import com.utilapi.controller.exception.ApiException;
import com.utilapi.core.dto.UserDTO;
import com.utilapi.core.facade.ICoreBank;
import com.utilapi.core.facade.ICoreEmail;
import com.utilapi.core.facade.ICoreOTPCode;
import com.utilapi.core.facade.ICoreUser;
import com.utilapi.persistence.dao.facade.IUserDAO;
import com.utilapi.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CoreUserImpl implements ICoreUser {

    private final IUserDAO userDAO;
    private final ICoreBank iCoreBank;

    @Autowired
    public CoreUserImpl(IUserDAO userDAO, ICoreBank iCoreBank) {
        this.userDAO = userDAO;
        this.iCoreBank = iCoreBank;
    }

    @Override
    public boolean registerUser(UserDTO bankUser) throws ApiException {
        UserDTO user;
        boolean response = false;

        if (UserDTO.validateAttributes(bankUser) && !bankUser.isBankEmployee()) {
             user = userDAO.createUser(bankUser);
//            boolean createdAccounts = iCoreBank.generateAccount(user.getIdentity());
            generateOTPsList(bankUser);
            response = Objects.nonNull(user);
        }
        return response;
    }

    private boolean generateOTPsList(UserDTO bankUser) {
        ICoreOTPCode otpCore = new CoreOTPCodeImpl();
        ICoreEmail mailCore = new CoreEmailImpl();
        List<String> otpCodes = otpCore.generateOTPCodes(bankUser.getUsername());

        String message = "Welcome " + bankUser.getName() + "\n" + "These are the OTP Codes you will be using to autenticate your transactions: \n";

        for (int i=0; i<otpCodes.size();i++) {
            message.concat(otpCodes.get(i)).concat(", ");
            if(i%4==0) message.concat("\n");
        }

        message.concat("Please be careful with those codes");
        mailCore.sendEmail(bankUser.getEmail(), "Insecure Bank registration.", message);

        return (otpCodes.size() == 100);
    }


    @Override
    public boolean loginUser(String username, String password) {
        return false;
    }

    @Override
    public boolean createAccounts(String sharedkey) {
        return false;
    }
}
