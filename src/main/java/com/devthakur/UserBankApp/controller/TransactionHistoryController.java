package com.devthakur.UserBankApp.controller;

import com.devthakur.UserBankApp.entity.TransactionHistory;
import com.devthakur.UserBankApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
//@CrossOrigin(origins = "http://localhost:5173")
public class TransactionHistoryController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions/{accountNumber}")
    public ResponseEntity<?> getTransactions(@PathVariable long accountNumber) {
        List<TransactionHistory> transactions = transactionService.getTransactionHistory(accountNumber);
        return transactions.isEmpty()
                ? ResponseEntity.status(404).body("No transactions found")
                : ResponseEntity.ok(transactions);
    }
}
