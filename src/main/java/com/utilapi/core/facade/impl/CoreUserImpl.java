package com.utilapi.core.facade.impl;

import com.utilapi.controller.exception.ApiException;
import com.utilapi.core.dto.UserDTO;
import com.utilapi.core.facade.ICoreBank;
import com.utilapi.core.facade.ICoreUser;
import com.utilapi.persistence.dao.facade.IUserDAO;
import com.utilapi.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        boolean response = false;

        if (UserDTO.validateAttributes(bankUser) && !bankUser.isBankEmployee()) {
            UserDTO user = userDAO.createUser(bankUser);
//            boolean createdAccounts = iCoreBank.generateAccount(user.getIdentity());
            response = Objects.nonNull(user);
        }
        return response;
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
