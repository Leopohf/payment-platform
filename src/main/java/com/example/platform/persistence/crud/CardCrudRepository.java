package com.example.platform.persistence.crud;

import com.example.platform.persistence.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardCrudRepository extends CrudRepository<Card, String>{

    Optional<Card> findByCardNumber(String cardNumber);
}
