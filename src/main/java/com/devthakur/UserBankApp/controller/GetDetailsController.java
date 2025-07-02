package com.devthakur.UserBankApp.controller;

import com.devthakur.UserBankApp.entity.CreateAccount;
import com.devthakur.UserBankApp.service.GetUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping("user")
//@CrossOrigin(origins = "http://localhost:5173")
    public class GetDetailsController {

    @Autowired
     GetUserDetailsService userService;


        @GetMapping("/{accountNumber}")
        public ResponseEntity<?> getUserDetails(@PathVariable long accountNumber) {
            CreateAccount account = userService.getUserDetails(accountNumber);
            if (account == null) {
                return ResponseEntity.status(404).body("Account not found.");
            }
            return ResponseEntity.ok(account);
        }
    }

