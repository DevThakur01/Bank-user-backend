package com.devthakur.UserBankApp.service;

import com.devthakur.UserBankApp.entity.CreateAccount;
import com.devthakur.UserBankApp.entity.TransactionHistory;
import com.devthakur.UserBankApp.repository.CreateAccountRepo;
import com.devthakur.UserBankApp.repository.TransactionHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;


@Component
public class TransferService {

    @Autowired
    private TransactionHistoryRepo transactionHistoryRepo;

    @Autowired
    private CreateAccountRepo createAccountRepo;

    public ResponseEntity<String> transferMoney(TransactionHistory transferRequest) {
        long senderAccNo = transferRequest.getSenderAccNo();
        long receiverAccNo = transferRequest.getReceiverAccNo();
        double amount = transferRequest.getAmount();

        CreateAccount sender = createAccountRepo.findByAccountNumber(senderAccNo);
        CreateAccount receiver = createAccountRepo.findByAccountNumber(receiverAccNo);

        if (sender == null || receiver == null) {
            return ResponseEntity.badRequest().body("Sender or Receiver account not found.");
        }

        if (sender.getBalance() < amount) {
            return ResponseEntity.badRequest().body("Insufficient balance in sender's account.");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        TransactionHistory history = new TransactionHistory();
        history.setSenderAccNo(senderAccNo);
        history.setReceiverAccNo(receiverAccNo);
        history.setAmount(amount);
        history.setTransactionDate(LocalDate.now());
        history.setType("Transfer");

        TransactionHistory savedTransaction = transactionHistoryRepo.save(history);

        if (sender.getTransactionIds() == null) sender.setTransactionIds(new ArrayList<>());
        if (receiver.getTransactionIds() == null) receiver.setTransactionIds(new ArrayList<>());

        sender.getTransactionIds().add(savedTransaction.getId());
        receiver.getTransactionIds().add(savedTransaction.getId());

        createAccountRepo.save(sender);
        createAccountRepo.save(receiver);

        return ResponseEntity.ok("Transfer successful");
    }
}
