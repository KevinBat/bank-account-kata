package com.bankaccount.kata.domain.operation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity representing an operation (deposit or withdrawal) made by client.
 */
public class Operation {

    private final Long id;
    private final Long accountNumber;
    private final String operationName; // String or enum
    private final LocalDateTime date;
    private final BigDecimal amount;
    private final BigDecimal balance;

    public Operation(Long id, Long accountNumber, String operationName, LocalDateTime date, BigDecimal amount, BigDecimal balance) {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
