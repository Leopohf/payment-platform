package com.example.platform.domain.service;

import com.example.platform.domain.TransactionRequest;
import com.example.platform.domain.enums.CardType;
import com.example.platform.domain.enums.TransactionType;
import com.example.platform.domain.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class ProcessTransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public void processTransaction(TransactionRequest transactionRequest) {
        // Check if the transaction card type is CREDIT
        if (!transactionRequest.getCardType().equals(CardType.CREDIT)) {
            throw new IllegalArgumentException("Only credit cards can be processed");
        }
        // Check transaction type
        if (transactionRequest.getTransactionType().equals(TransactionType.PURCHASE)) {

            // Evaluate transaction request expiration date
            // Get Date Time from String
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy").withZone(ZoneId.of("UTC"));
            YearMonth expirationDate = YearMonth.parse(transactionRequest.getCardExpirationDate(), formatter);

            LocalDateTime expirationDateTime = expirationDate.atDay(1).atStartOfDay();
            LocalDateTime now = LocalDateTime.now();
            if (expirationDateTime.isBefore(now)) {
                throw new IllegalArgumentException("Card expired");
            }

            // Check transaction amount
            if (transactionRequest.getAmount() <= 0) {
                throw new IllegalArgumentException("Invalid amount");
            }

            transactionRepository.save(transactionRequest);
        } else if (transactionRequest.getTransactionType().equals(TransactionType.REFUND)) {
            transactionRepository.getLastTransactionByCardNumber(transactionRequest.getCardNumber());

            transactionRepository.save(transactionRequest);
        } else {
            throw new IllegalArgumentException("Invalid transaction type");
        }
    }
}
