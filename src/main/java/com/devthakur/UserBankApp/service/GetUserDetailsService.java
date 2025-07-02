package com.devthakur.UserBankApp.service;

import com.devthakur.UserBankApp.entity.CreateAccount;
import com.devthakur.UserBankApp.repository.CreateAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserDetailsService {

    @Autowired
    CreateAccountRepo createAccountRepo;

    public CreateAccount getUserDetails(long accountNumber) {
        return createAccountRepo.findByAccountNumber(accountNumber);
    }
}