package com.shritej.springsec.repository;

import com.shritej.springsec.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends CrudRepository<AccountTransactions, Long> {


    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(long id);
}
