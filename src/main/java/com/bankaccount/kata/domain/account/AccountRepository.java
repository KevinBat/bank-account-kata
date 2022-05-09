package com.bankaccount.kata.domain.account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findByAccountNumber(Long accountNumber);

    Account save(Account account);

}
