package com.utilapi.persistence.dao.impl;

import com.google.gson.Gson;
import com.utilapi.core.dto.TransactionDTO;
import com.utilapi.persistence.dao.facade.ITransactionDAO;
import com.utilapi.persistence.entity.TransactionEntity;
import com.utilapi.persistence.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionDao implements ITransactionDAO {

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public String setTransaction(TransactionDTO transactionDTO) {
        return transactionRepository.save(buildTransactionEntity(transactionDTO)).getTransactionId();
    }

    @Override
    public List<TransactionDTO> retrieveByUser(String originAccount) {
        List<TransactionEntity> transactionEntities = transactionRepository.findByOriginAccount(originAccount);
        List<TransactionDTO> transactionDTOS = transactionEntities.stream().map(transactionEntity -> buildTransactionDTO(transactionEntity)).collect(Collectors.toList());
        return transactionDTOS;
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

    private TransactionDTO buildTransactionDTO(TransactionEntity transactionEntity){
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(transactionEntity), TransactionDTO.class);
    }
}