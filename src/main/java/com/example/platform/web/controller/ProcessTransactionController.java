package com.example.platform.web.controller;

import com.example.platform.domain.TransactionRequest;
import com.example.platform.domain.service.ProcessTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class ProcessTransactionController {
    @Autowired
    private ProcessTransactionService processTransactionService;

    @RequestMapping("/process")
    public void processTransaction(@RequestBody TransactionRequest transactionRequest) {
        processTransactionService.processTransaction(transactionRequest);
    }
}
