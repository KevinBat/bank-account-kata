package com.bankaccount.kata.domain.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    private OperationService classUnderTest;

    @Mock
    OperationRepository operationRepository;

    @BeforeEach
    public void init() {
        classUnderTest = new OperationService(operationRepository);
    }

    @Test
    void createDepositOperation() {
        Long accountNumber = 123L;
        double amount = 1.0D;
        double balance = 1.0D;

        classUnderTest.createDepositOperation(accountNumber, amount, balance);

        Mockito.verify(operationRepository, Mockito.times(1)).save(any());
    }

    @Test
    void createWithdrawalOperation() {
        Long accountNumber = 123L;
        double amount = 1.0D;
        double balance = 1.0D;

        classUnderTest.createWithdrawalOperation(accountNumber, amount, balance);

        Mockito.verify(operationRepository, Mockito.times(1)).save(any());
    }

    @Test
    void findOperationsByAccountNumber() {
        Long accountNumber = 123L;

        Operation operationExpected = new Operation(0L, accountNumber, "Deposit", LocalDateTime.now(), 1.0D, 2.0D);
        List<Operation> operationsExpected = Collections.singletonList(operationExpected);

        when(operationRepository.findByAccountNumber(accountNumber)).thenReturn(operationsExpected);

        List<Operation> actual = classUnderTest.findOperationsByAccountNumber(accountNumber);

        Assertions.assertEquals(operationsExpected, actual);
    }
}