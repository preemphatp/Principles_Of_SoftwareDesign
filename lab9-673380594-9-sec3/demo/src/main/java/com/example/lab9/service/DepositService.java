package com.example.lab9.service;

import org.springframework.stereotype.Service;

import com.example.lab9.model.Account;
import com.example.lab9.model.DepositTransaction;
import com.example.lab9.repository.AccountRepository;
import com.example.lab9.repository.DepositRepository;

import jakarta.transaction.Transactional;

@Service
public class DepositService {
    private final DepositRepository depositRepository;
    private final AccountRepository accountRepository;

    public DepositService(DepositRepository depositRepository,AccountRepository accountRepository) {
        this.depositRepository = depositRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void deposit(Long accountId, Double amount){
    
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found: " + accountId));
        
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
        DepositTransaction depositTransaction = new DepositTransaction();
        depositTransaction.setAmount(amount);
        depositTransaction.setAccount(account);
        depositRepository.save(depositTransaction);
    }
}