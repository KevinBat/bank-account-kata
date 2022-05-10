package com.bankaccount.kata.domain.operation;

import java.time.LocalDateTime;

/**
 * Entity representing an operation (deposit or withdrawal) made by client.
 */
public class Operation {

    private Long id;
    private Long accountNumber;
    private String operationName;
    private LocalDateTime date;
    private double amount;
    private double balance;

    public Operation(Long id, Long accountNumber, String operationName, LocalDateTime date, double amount, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.operationName = operationName;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getOperationName() {
        return operationName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }


}
