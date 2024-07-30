package com.example.platform.persistence;

import com.example.platform.domain.TransactionRequest;
import com.example.platform.persistence.crud.CardCrudRepository;
import com.example.platform.persistence.crud.TransactionCrudRepository;
import com.example.platform.persistence.entity.Transaction;
import com.example.platform.persistence.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class TransactionRepository implements com.example.platform.domain.repository.TransactionRepository {
    @Autowired
    private TransactionCrudRepository transactionCrudRepository;
    @Autowired
    private CardCrudRepository cardCrudRepository;
    @Autowired
    private TransactionMapper mapper;

    @Override
    public Transaction save(TransactionRequest transactionRequest) {
        long id = transactionCrudRepository.count() + 1;
        Transaction transaction = mapper.toTransaction(transactionRequest);
        transaction.setIdTransaction((int) id);
        transaction.setTransactionDate(LocalDateTime.now());

        cardCrudRepository.findByCardNumber(transactionRequest.getCardNumber()).ifPresent(transaction::setCard);

        return transactionCrudRepository.save(transaction);
    }

    @Override
    public Transaction getLastTransactionByCardNumber(String cardNumber) {
        return transactionCrudRepository.findFirstByCardNumberOrderByTransactionDateDesc(cardNumber);
    }
}
