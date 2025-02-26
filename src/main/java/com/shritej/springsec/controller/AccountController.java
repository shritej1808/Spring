package com.shritej.springsec.controller;

import com.shritej.springsec.model.Accounts;
import com.shritej.springsec.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
     private final AccountsRepository accountsRepository;
    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam long Id) {
       if(accountsRepository.findByCustomerId(Id) != null) {
           return accountsRepository.findByCustomerId(Id);
       }
       return null;
    }

}
