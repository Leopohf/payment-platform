package com.example.platform.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @Column(name = "card_number")
    private String cardnumber;

    @Column(name = "id_cardholder")
    private Integer idCardHolder;

    @Column(name = "card_type")
    private String cardType;

    @ManyToOne
    @JoinColumn(name = "id_cardholder", insertable = false, updatable = false)
    private CardHolder cardHolder;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactions;

}
