package com.example.platform.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "cardholders")
public class CardHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cardholder")
    private Integer idCardHolder;

    private String name;

    private String lastname;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "birthdate")
    private LocalDateTime birthDate;

    private Boolean status;

    @OneToMany(mappedBy = "idCardHolder")
    private List<Card> cards;
}
