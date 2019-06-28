package com.utilapi.persistence.dao.facade;

import com.utilapi.core.dto.TransactionDTO;
import com.utilapi.persistence.entity.TransactionEntity;

import java.util.List;

public interface ITransactionDAO {

    String setTransaction(TransactionDTO transactionDTO);

    List<TransactionDTO> retrieveByUser(String originAccount);

    Iterable<TransactionEntity> retrieveAll();

}