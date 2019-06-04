package com.utilapi.persistence.dao.impl;

import com.utilapi.core.dto.AccountDTO;
import com.utilapi.persistence.dao.facade.IAccountDAO;
import com.utilapi.persistence.entity.AccountEntity;
import com.utilapi.persistence.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDao implements IAccountDAO {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountDao(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO getAccount(String id) {
        return buildAccountDTO(accountRepository.findById(id).orElse(new AccountEntity()));
    }

    @Override
    public int insertAccount(AccountDTO accountDTO) {
        return accountRepository.save(buildAccountEntity(accountDTO)).getId();
    }

    private AccountDTO buildAccountDTO(AccountEntity accountEntity){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber(accountEntity.getId());
        accountDTO.setBalance(accountEntity.getBalance());
        accountDTO.setOwner(accountEntity.getOwner());
        return accountDTO;
    }

    private AccountEntity buildAccountEntity(AccountDTO accountDTO) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(accountDTO.getAccountNumber());
        accountEntity.setBalance(accountDTO.getBalance());
        accountEntity.setOwner(accountDTO.getOwner());
        return accountEntity;
    }
}