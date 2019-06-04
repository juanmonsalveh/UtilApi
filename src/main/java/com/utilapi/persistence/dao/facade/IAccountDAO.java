package com.utilapi.persistence.dao.facade;

import com.utilapi.core.dto.AccountDTO;

import java.util.List;

public interface IAccountDAO {

    AccountDTO getAccount(String id);
    int insertAccount(AccountDTO accountDTO);
}