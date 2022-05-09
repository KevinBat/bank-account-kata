package com.bankaccount.kata.domain.operation;

import java.util.List;

public interface OperationRepository {

    List<Operation> findByAccountNumber(Long accountNumber);

    Operation save(Operation operation);

}
