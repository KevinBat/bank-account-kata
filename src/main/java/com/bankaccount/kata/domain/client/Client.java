package com.bankaccount.kata.domain.client;

import java.util.List;

/**
 * Entity representing a bank client.
 */
public class Client {

    private final Long id;
    private final List<Long> accountNumbers;

    public Client(Long id, List<Long> accountNumbers) {
        this.id = id;
        this.accountNumbers = accountNumbers;
    }
}
