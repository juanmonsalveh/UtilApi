package com.utilapi.persistence.dao.impl;

import com.utilapi.core.dto.TransactionDTO;
import com.utilapi.persistence.dao.facade.ITransactionDAO;
import com.utilapi.persistence.entity.TransactionEntity;
import com.utilapi.persistence.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionDao implements ITransactionDAO {

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public String setTransaction(TransactionDTO transactionDTO) {
        return transactionRepository.save(buildTransactionEntity(transactionDTO)).getTransactionId();
    }

    @Override
    public TransactionEntity retrieveByUser(String originAccount) {
        return transactionRepository.retrieveByUser(originAccount);
    }

    @Override
    public Iterable<TransactionEntity> retrieveAll() {
        return transactionRepository.findAll();
    }


    private TransactionEntity buildTransactionEntity(TransactionDTO transactionDTO){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmmount(transactionDTO.getAmmount());
        transactionEntity.setDate(transactionDTO.getDate());
        transactionEntity.setDestinationAccount(transactionDTO.getDestinationAccount());
        transactionEntity.setOriginAccount(transactionDTO.getOriginAccount());
        transactionEntity.setOtpCode(transactionDTO.getOtpCode());
        transactionEntity.setTransactionId(transactionDTO.getTransactionId());
        return transactionEntity;
    }
}