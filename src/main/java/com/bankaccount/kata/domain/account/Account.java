package com.bankaccount.kata.domain.account;

import java.math.BigDecimal;

/**
 * Entity representing a bank account
 */
public class Account {

    private final Long accountNumber;
    private BigDecimal balance;

    public Account(Long accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void makeDeposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance = this.balance.add(amount);
    }


    public void makeWithdrawal(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Amount must be less than balance");
        }
        this.balance = this.balance.subtract(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
