package com.bankaccount.kata.domain.client;

import com.bankaccount.kata.domain.account.Account;
import com.bankaccount.kata.domain.account.AccountRepository;
import com.bankaccount.kata.domain.operation.Operation;
import com.bankaccount.kata.domain.operation.OperationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    private ClientService classUnderTest;

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private OperationService operationService;

    @BeforeEach
    public void init() {
        classUnderTest = new ClientService(accountRepository, operationService);
    }

    @Test
    void clientMakeDeposit() {
        Long accountNumber = 123L;
        double amount = 1.0D;

        Account accountExpected = mock(Account.class); // new Account(123L, BigDecimal.ONE);
        BigDecimal balanceExpected = BigDecimal.valueOf(2);

        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(accountExpected));
        when(accountExpected.getBalance()).thenReturn(balanceExpected);

        classUnderTest.clientMakeDeposit(accountNumber, amount);

        Mockito.verify(accountExpected, Mockito.times(1)).makeDeposit(BigDecimal.valueOf(amount));
        Mockito.verify(accountRepository, Mockito.times(1)).save(accountExpected);
        Mockito.verify(operationService, Mockito.times(1)).createDepositOperation(accountNumber, amount, balanceExpected.doubleValue());
    }

    @Test
    void clientMakeWithdrawal() {
        Long accountNumber = 123L;
        double amount = 1.0D;

        Account accountExpected = mock(Account.class); // new Account(123L, BigDecimal.ONE);
        BigDecimal balanceExpected = BigDecimal.valueOf(0);

        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(accountExpected));
        when(accountExpected.getBalance()).thenReturn(balanceExpected);

        classUnderTest.clientMakeWithdrawal(accountNumber, amount);

        Mockito.verify(accountExpected, Mockito.times(1)).makeWithdrawal(BigDecimal.valueOf(amount));
        Mockito.verify(accountRepository, Mockito.times(1)).save(accountExpected);
        Mockito.verify(operationService, Mockito.times(1)).createWithdrawalOperation(accountNumber, amount, balanceExpected.doubleValue());
    }

    @Test
    void clientSeeHistory() {
        Long accountNumber = 123L;

        Operation operationExpected = new Operation(0L, accountNumber, "Deposit", LocalDateTime.now(), 1.0D, 2.0D);
        List<Operation> operationsExpected = Collections.singletonList(operationExpected);

        when(operationService.findOperationsByAccountNumber(accountNumber)).thenReturn(operationsExpected);

        List<Operation> actual = classUnderTest.clientSeeHistory(accountNumber);

        Assertions.assertEquals(operationsExpected, actual);
    }
}