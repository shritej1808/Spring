package com.shritej.springsec.controller;

import com.shritej.springsec.model.Cards;
import com.shritej.springsec.model.Customer;
import com.shritej.springsec.repository.CardsRepository;
import com.shritej.springsec.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CardsController {
    private final CustomerRepository customerRepository;
    private final CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            List<Cards> cards = cardsRepository.findByCustomerId(optionalCustomer.get().getId());
            if (cards != null) {
                return cards;
            } else {
                return null;
            }
        }
        return null;
    }
}
