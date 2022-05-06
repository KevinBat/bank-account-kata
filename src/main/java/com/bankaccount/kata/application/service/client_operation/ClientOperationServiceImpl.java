package com.bankaccount.kata.application.service.client_operation;

import com.bankaccount.kata.domain.client.ClientService;

public class ClientOperationServiceImpl implements ClientOperationService {

    private final ClientService clientService;

    public ClientOperationServiceImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void clientMakeDeposit(long clientId, long accountNumber, int amount) {

    }

    @Override
    public void clientMakeWithdrawal(long clientId, long accountNumber, int amount) {

    }

    @Override
    public void clientSeeHistory(long clientId, long accountNumber) {

    }

}
