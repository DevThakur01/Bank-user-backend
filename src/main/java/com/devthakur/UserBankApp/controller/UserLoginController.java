package com.devthakur.UserBankApp.controller;


import com.devthakur.UserBankApp.dto.LoginRequest;
import com.devthakur.UserBankApp.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:5173")
public class UserLoginController {

    @Autowired
    private UserLoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return loginService.loginUser(request.getAccountNumber(), request.getPin());
    }
}

