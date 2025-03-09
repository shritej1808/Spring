package com.shritej.springsec.controller;

import com.shritej.springsec.model.Customer;
import com.shritej.springsec.model.Loans;
import com.shritej.springsec.repository.CustomerRepository;
import com.shritej.springsec.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoansController {
    private final CustomerRepository customerRepository;
    private final LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        Optional<Customer> customerOptional=customerRepository.findByEmail(email);
        if(customerOptional.isPresent()){
            List<Loans> loans=loanRepository.findByCustomerIdOrderByStartDtDesc(customerOptional.get().getId());
            if(loans!=null){
                return loans;
            }else{
                return null;
            }
        }
        return null;
    }

}
