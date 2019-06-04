package com.utilapi.core.facade.impl;

import com.utilapi.core.dto.AccountDTO;
import com.utilapi.core.dto.UserDTO;
import com.utilapi.core.facade.ICoreBank;
import com.utilapi.persistence.dao.facade.IAccountDAO;
import com.utilapi.persistence.dao.impl.UserDao;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreBankImpl implements ICoreBank {

    private final IAccountDAO accountDAO;

    @Autowired
    public CoreBankImpl(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public boolean generateAccount(int username) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setOwner(username);
        accountDTO.setAccountNumber(Integer.parseInt(RandomStringUtils.random(6, false, true)));
        accountDTO.setBalance(RandomStringUtils.random(6, 100000,200000,false, true));
        return accountDAO.insertAccount(accountDTO) == 0;
    }
}
