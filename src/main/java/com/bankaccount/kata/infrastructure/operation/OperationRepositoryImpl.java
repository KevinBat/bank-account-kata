package com.bankaccount.kata.infrastructure.operation;

import com.bankaccount.kata.domain.operation.Operation;
import com.bankaccount.kata.domain.operation.OperationRepository;

import java.util.List;

public class OperationRepositoryImpl implements OperationRepository {

    @Override
    public List<Operation> findByAccountNumber(Long accountNumber) {
        return null;
    }

    @Override
    public Operation save(Operation operation) {
        return null;
    }
}
