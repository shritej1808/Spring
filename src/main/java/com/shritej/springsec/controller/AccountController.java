package com.shritej.springsec.controller;

import com.shritej.springsec.model.Accounts;
import com.shritej.springsec.model.Customer;
import com.shritej.springsec.repository.AccountsRepository;
import com.shritej.springsec.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final CustomerRepository customerRepository;
     private final AccountsRepository accountsRepository;
    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
        Optional<Customer> optionalCustomer=customerRepository.findByEmail(email);
        if(optionalCustomer.isPresent()){
            Accounts accounts=accountsRepository.findByCustomerId(optionalCustomer.get().getId());
            if (accounts!=null){
                return accounts;
            }
            else {
                return null;
            }
        }
        return null;
    }

}
