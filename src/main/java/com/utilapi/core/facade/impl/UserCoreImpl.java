package com.utilapi.core.facade.impl;

import com.utilapi.controller.exception.ApiException;
import com.utilapi.core.dto.UserDTO;
import com.utilapi.core.facade.ICoreBank;
import com.utilapi.core.facade.ICoreUser;
import com.utilapi.persistence.dao.facade.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCoreImpl implements ICoreUser {

    @Autowired
    private IUserDAO iCoreUser;
    @Autowired
    private ICoreBank iCoreBank;

    @Override
    public boolean registerUser(UserDTO bankUser) throws ApiException {

        if (UserDTO.validateAttributes(bankUser) && !bankUser.isBankEmployee()) {
            boolean createdAccounts = iCoreBank.generateAccount(bankUser.getIdentity());
        }
        return false;
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
