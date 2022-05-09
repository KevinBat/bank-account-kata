package com.bankaccount.kata.domain.client;

import com.bankaccount.kata.domain.account.Account;
import com.bankaccount.kata.domain.account.AccountRepository;
import com.bankaccount.kata.domain.operation.Operation;
import com.bankaccount.kata.domain.operation.OperationService;

import java.math.BigDecimal;
import java.util.List;

public class ClientService {

    private final AccountRepository accountRepository;
    private final OperationService operationService;

    public ClientService(AccountRepository accountRepository, OperationService operationService) {
        this.accountRepository = accountRepository;
        this.operationService = operationService;
    }

    public void clientMakeDeposit(long accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(IllegalArgumentException::new);
        account.makeDeposit(BigDecimal.valueOf(amount));
        accountRepository.save(account);

        operationService.createDepositOperation(accountNumber, amount, account.getBalance().doubleValue());
    }

    public void clientMakeWithdrawal(long accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(IllegalArgumentException::new);
        account.makeWithdrawal(BigDecimal.valueOf(amount));
        accountRepository.save(account);

        operationService.createWithdrawalOperation(accountNumber, amount, account.getBalance().doubleValue());
    }

    public List<Operation> clientSeeHistory(long accountNumber) {
        return operationService.findOperationsByAccountNumber(accountNumber);
    }

}
