package com.shritej.springsec.controller;

import com.shritej.springsec.model.Cards;
import com.shritej.springsec.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public ResponseEntity<List<Cards>> getCardDetails(@RequestParam long id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards.isEmpty()) {
            return ResponseEntity.notFound().build();  // Returns 404 if no cards are found
        }
        return ResponseEntity.ok(cards);  // Returns 200 with the cards
    }
}
