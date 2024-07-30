package com.example.platform.persistence.crud;

import com.example.platform.persistence.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionCrudRepository extends CrudRepository<Transaction, Integer> {
    Transaction findFirstByCardNumberOrderByTransactionDateDesc(String cardNumber);

}
