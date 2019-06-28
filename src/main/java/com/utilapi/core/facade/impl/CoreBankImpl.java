package com.utilapi.core.facade.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.utilapi.core.dto.AccountDTO;
import com.utilapi.core.dto.TransactionDTO;
import com.utilapi.core.facade.ICoreBank;
import com.utilapi.persistence.dao.facade.IAccountDAO;
import com.utilapi.persistence.dao.facade.ITransactionDAO;
import com.utilapi.persistence.entity.TransactionEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreBankImpl implements ICoreBank {

    private final IAccountDAO accountDAO;

    private final ITransactionDAO transactionDAO;

    @Autowired
    public CoreBankImpl(IAccountDAO accountDAO, ITransactionDAO transactionDAO) {
        this.accountDAO = accountDAO;
        this.transactionDAO = transactionDAO;
    }

    @Override
    public boolean generateAccount(int username) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setOwner(username);
        accountDTO.setAccountNumber(Integer.parseInt(RandomStringUtils.random(6, false, true)));
        accountDTO.setBalance(RandomStringUtils.random(6, 100000,200000,false, true));
        return accountDAO.insertAccount(accountDTO) == 0;
    }

    @Override
    public List<TransactionDTO> retrieveTransactions() {
        return null;
    }

    @Override
    public List<TransactionDTO> retrieveTransactions(String username) {
        return transactionDAO.retrieveByUser(username);
    }

    @Override
    public boolean validateTransactionOtp(String otp, String sharedKey) {
        return false;
    }

    @Override
    public TransactionDTO createTransactionDto(TransactionDTO transactionDTO) {
        return null;
    }

    private TransactionDTO mapTransactionDTO(TransactionEntity transactionEntity){
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(transactionEntity), TransactionDTO.class);
    }
}
