package com.shritej.springsec.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id", updatable = false, nullable = false)
    private long cardId;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "card_number", nullable = false, unique = true)
    private String cardNumber;

    @Column(name = "card_type", nullable = false)
    private String cardType;  // Example: "Credit Card", "Debit Card"

    @Column(name = "total_limit", nullable = false)
    private int totalLimit;

    @Column(name = "amount_used", nullable = false)
    private int amountUsed;

    @Column(name = "available_amount", nullable = false)
    private int availableAmount;

    @Column(name = "create_dt", nullable = false)
    private LocalDate createDt;  // Changed to LocalDate for better date handling
}
