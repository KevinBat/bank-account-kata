package com.bankaccount.kata.application.service.client_operation;

import com.bankaccount.kata.domain.client.ClientService;
import com.bankaccount.kata.domain.operation.Operation;

import java.util.List;

public class ClientOperationServiceImpl implements ClientOperationService {

    private final ClientService clientService;

    public ClientOperationServiceImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void clientMakeDeposit(long accountNumber, int amount) {
        clientService.clientMakeDeposit(accountNumber, amount);
    }

    @Override
    public void clientMakeWithdrawal(long accountNumber, int amount) {
        clientService.clientMakeWithdrawal(accountNumber, amount);
    }

    @Override
    public void clientSeeHistory(long accountNumber) {
        List<Operation> operations = clientService.clientSeeHistory(accountNumber);
        // return the list of dto
    }

}
