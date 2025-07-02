package com.devthakur.UserBankApp.controller;

import com.devthakur.UserBankApp.entity.TransactionHistory;
import com.devthakur.UserBankApp.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
//@CrossOrigin(origins = "http://localhost:5173")
public class TransferController {

    @Autowired
    TransferService transferservice;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransactionHistory transactionHistory) {
        return transferservice.transferMoney(transactionHistory);
    }
}
