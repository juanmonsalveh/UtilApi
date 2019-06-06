package com.utilapi.persistence.dao.facade;

import com.utilapi.core.dto.TransactionDTO;
import com.utilapi.persistence.entity.TransactionEntity;

public interface ITransactionDAO {

    String setTransaction(TransactionDTO transactionDTO);

    TransactionEntity retrieveByUser(String originAccount);

    Iterable<TransactionEntity> retrieveAll();

}