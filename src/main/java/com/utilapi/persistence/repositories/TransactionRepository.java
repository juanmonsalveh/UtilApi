package com.utilapi.persistence.repositories;

import com.utilapi.persistence.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {

    TransactionEntity retrieveByUser(String user);

}
