package com.example.platform.domain;

import com.example.platform.domain.enums.CardType;
import com.example.platform.domain.enums.TransactionType;
import lombok.Data;

@Data
public class TransactionRequest {
    private TransactionType transactionType;
    private Double amount;
    private String merchantId;
    private String category;
    private String description;
    private String cardNumber;
    private CardType cardType;
    private String cardExpirationDate;
    private String cardCVV;
}
