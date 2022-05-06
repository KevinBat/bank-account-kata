package com.bankaccount.kata.application.service.client_operation;

public interface ClientOperationService {

    void clientMakeDeposit(long clientId, long accountNumber, int amount);

    void clientMakeWithdrawal(long clientId, long accountNumber, int amount);

    void clientSeeHistory(long clientId, long accountNumber);

}
