package com.shritej.springsec.repository;

import com.shritej.springsec.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, String> {
    Accounts findByCustomerId(long customerId);
}
