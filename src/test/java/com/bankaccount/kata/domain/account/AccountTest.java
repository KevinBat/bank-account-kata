package com.bankaccount.kata.domain.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {

    private Account classUnderTest;

    @BeforeEach
    public void init() {
        classUnderTest = new Account(123L, BigDecimal.ONE);
    }

    // makeDeposit

    @Test
    void givenPositiveAmount_whenMakeDeposit_ThenBalanceIncrease() {
        BigDecimal amount = BigDecimal.ONE;
        BigDecimal expected = BigDecimal.valueOf(2L);

        classUnderTest.makeDeposit(amount);

        assertEquals(classUnderTest.getBalance(), expected);
    }

    @Test
    void givenNegativeAmount_whenMakeDeposit_ThenThrowIllegal() {
        BigDecimal amount = BigDecimal.valueOf(-1L);

        assertThrows(IllegalArgumentException.class, () -> classUnderTest.makeDeposit(amount));
    }

    // makeWithdrawal

    @Test
    void givenPositiveAmount_whenMakeWithDrawal_ThenBalanceDecrease() {
        BigDecimal amount = BigDecimal.ONE;
        BigDecimal expected = BigDecimal.ZERO;

        classUnderTest.makeWithdrawal(amount);

        assertEquals(classUnderTest.getBalance(), expected);
    }

    @Test
    void givenNegativeAmount_whenWithdrawal_ThenThrowIllegal() {
        BigDecimal amount = BigDecimal.valueOf(-1L);

        assertThrows(IllegalArgumentException.class, () -> classUnderTest.makeWithdrawal(amount));
    }

    @Test
    void giventooBigAmount_whenWithdrawal_ThenThrowIllegal() {
        BigDecimal amount = BigDecimal.TEN;

        assertThrows(IllegalArgumentException.class, () -> classUnderTest.makeWithdrawal(amount));
    }
}