package com.devthakur.UserBankApp.service;


import com.devthakur.UserBankApp.entity.CreateAccount;
import com.devthakur.UserBankApp.entity.TransactionHistory;
import com.devthakur.UserBankApp.repository.CreateAccountRepo;
import com.devthakur.UserBankApp.repository.TransactionHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionService {

    @Autowired
    private TransactionHistoryRepo transactionHistoryRepo;

    @Autowired
    private CreateAccountRepo createAccountRepo;

    public List<TransactionHistory> getTransactionHistory(long accountNumber) {
        CreateAccount account = createAccountRepo.findByAccountNumber(accountNumber);

        if (account == null || account.getTransactionIds() == null || account.getTransactionIds().isEmpty()) {
            return List.of(); // return empty list if not found or no transactions
        }

        return transactionHistoryRepo.findByIdIn(account.getTransactionIds());
    }
}