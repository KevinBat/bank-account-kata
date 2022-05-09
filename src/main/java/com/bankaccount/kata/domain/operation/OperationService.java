package com.bankaccount.kata.domain.operation;

import java.time.LocalDateTime;
import java.util.List;

public class OperationService {

    private final OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void createDepositOperation(Long accountNumber, double amount, double balance) {
        Operation operation = new Operation(0L, accountNumber, "Deposit", LocalDateTime.now(), amount, balance);
        operationRepository.save(operation);
    }

    public void createWithdrawalOperation(Long accountNumber, double amount, double balance) {
        Operation operation = new Operation(0L, accountNumber, "Withdrawal", LocalDateTime.now(), amount, balance);
        operationRepository.save(operation);
    }

    public List<Operation> findOperationsByAccountNumber(Long accountNumber) {
        return operationRepository.findByAccountNumber(accountNumber);
    }

}
