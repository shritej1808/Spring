package com.shritej.springsec.controller;

import com.shritej.springsec.model.AccountTransactions;
import com.shritej.springsec.model.Customer;
import com.shritej.springsec.repository.AccountTransactionRepository;
import com.shritej.springsec.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TransferQueue;

@RestController
@RequiredArgsConstructor
public class BalanceController {
    private final CustomerRepository customerRepository;
    private final AccountTransactionRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);

        if (optionalCustomer.isPresent()) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(optionalCustomer.get().getId());
        if(accountTransactions!=null){
            return accountTransactions;
        }else{
            return null;
        }
        }
        return null;
    }
}
