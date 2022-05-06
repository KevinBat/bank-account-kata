package com.bankaccount.kata.domain.client;

import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findById(long id);

}
