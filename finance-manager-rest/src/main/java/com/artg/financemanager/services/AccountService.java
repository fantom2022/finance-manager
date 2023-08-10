package com.artg.financemanager.services;

import com.artg.financemanager.dtos.AccountDto;
import com.artg.financemanager.entities.Account;
import com.artg.financemanager.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public void create(AccountDto dto) {
        this.accountRepository.save(new Account(dto));
    }

    @Transactional
    public void delete(Long accountId) {
        Account existingAccount = this.accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Счёт не найден"));
        existingAccount.delete();
    }

}
