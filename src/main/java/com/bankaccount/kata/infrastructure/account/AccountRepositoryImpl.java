package com.bankaccount.kata.infrastructure.account;

import com.bankaccount.kata.domain.account.Account;
import com.bankaccount.kata.domain.account.AccountRepository;

import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public Optional<Account> findByAccountNumber(Long accountNumber) {
        return Optional.empty();
    }

    @Override
    public Account save(Account account) {
        return null;
    }

}
