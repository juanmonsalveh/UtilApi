package com.utilapi.persistence.repositories;

import com.utilapi.persistence.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, String> {

}
