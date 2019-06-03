package com.utilapi.core.facade.impl;

import com.utilapi.controller.exception.ApiException;
import com.utilapi.core.dto.UserDTO;
import com.utilapi.core.facade.ICoreBank;
import com.utilapi.core.facade.ICoreEmail;
import com.utilapi.core.facade.ICoreOTPCode;
import com.utilapi.core.facade.ICoreUser;
import com.utilapi.persistence.dao.facade.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CoreUserImpl implements ICoreUser {

    private final IUserDAO userDAO;
    private final ICoreBank iCoreBank;
    private final ICoreEmail mailCore;
    private final ICoreOTPCode otpCore;

    @Autowired
    public CoreUserImpl(IUserDAO userDAO, ICoreBank iCoreBank, ICoreEmail mailCore, ICoreOTPCode otpCore) {
        this.userDAO = userDAO;
        this.iCoreBank = iCoreBank;
        this.mailCore = mailCore;
        this.otpCore = otpCore;
    }

    @Override
    public boolean registerUser(UserDTO bankUser) throws ApiException {
        UserDTO user;
        boolean response = false;

        if (UserDTO.validateAttributes(bankUser) && !bankUser.isBankEmployee()) {
             user = userDAO.createUser(bankUser);
//            boolean createdAccounts = iCoreBank.generateAccount(user.getIdentity());
            List<String> otpCodes = generateUserOTPsListAndSendItByEmail(bankUser);
            response = Objects.nonNull(user);
        }
        return response;
    }

    private List<String> generateUserOTPsListAndSendItByEmail(UserDTO bankUser) {
        //ICoreOTPCode otpCore = new CoreOTPCodeImpl();
        //ICoreEmail mailCore = new CoreEmailImpl();

        List<String> otpCodes = otpCore.generateOTPCodes(bankUser.getUsername());
        String mailFrom = System.getProperty("spring.mail.username", "Easybank.2019@gmail.com");
        String mailSubject = "Insecure Bank registration - " + new Date();
        String mailBody = mailCore.buildOTPListMailBody(bankUser.getUsername(), otpCodes);

        mailCore.sendEmail(mailFrom, bankUser.getEmail(), mailSubject, mailBody);

        return otpCodes;
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
