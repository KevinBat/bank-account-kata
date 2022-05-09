package com.bankaccount.kata.application.service.client_operation;

public interface ClientOperationService {

    void clientMakeDeposit(long accountNumber, int amount);

    void clientMakeWithdrawal(long accountNumber, int amount);

    void clientSeeHistory(long accountNumber);

}
