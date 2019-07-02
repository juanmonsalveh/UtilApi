package com.utilapi.persistence.repositories;

import com.utilapi.persistence.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {

    List<TransactionEntity> findByOriginAccount(String originAccount);

}
