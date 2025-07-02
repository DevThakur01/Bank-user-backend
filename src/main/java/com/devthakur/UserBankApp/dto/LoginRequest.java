package com.devthakur.UserBankApp.dto;


public class LoginRequest {
    private long accountNumber;
    private String pin;

    // Getters and setters
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}