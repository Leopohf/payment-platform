package com.example.platform.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "id_transaction")
    private Integer idTransaction;

    private Double amount;

    @Column(name = "date")
    private LocalDateTime transactionDate;

    private String merchant;

    private String category;

    private String description;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @ManyToOne
    @JoinColumn(name = "card_number", insertable = false, updatable = false)
    private Card card;
}
