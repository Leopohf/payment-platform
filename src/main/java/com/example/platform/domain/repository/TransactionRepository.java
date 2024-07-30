package com.example.platform.domain.repository;

import com.example.platform.domain.TransactionRequest;
import com.example.platform.persistence.entity.Transaction;

public interface TransactionRepository {
    Transaction save(TransactionRequest transactionRequest);
    Transaction getLastTransactionByCardNumber(String cardNumber);
}
