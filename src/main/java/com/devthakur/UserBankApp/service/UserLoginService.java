package com.devthakur.UserBankApp.service;

import com.devthakur.UserBankApp.entity.CreateAccount;
import com.devthakur.UserBankApp.repository.CreateAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class UserLoginService {

    @Autowired
    private CreateAccountRepo accountRepo;

    public ResponseEntity<String> loginUser(long accountNumber, String pin) {
        CreateAccount account = accountRepo.findByAccountNumber(accountNumber);

        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
        }

        if (!account.getPin().equals(pin)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect PIN.");
        }

        return ResponseEntity.ok("Login successful");
    }

}

