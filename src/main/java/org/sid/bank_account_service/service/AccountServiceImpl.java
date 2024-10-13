package org.sid.bank_account_service.service;

import jakarta.transaction.Transactional;
import org.sid.bank_account_service.Dtos.BankAccountRequestDto;
import org.sid.bank_account_service.Dtos.BankAccountRespondeDto;
import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Reposotories.BankAccountRepository;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private  BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountRespondeDto addAccount(BankAccountRequestDto accountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .creatDate(new Date())
                .balance(accountDto.getBalance())
                .type(accountDto.getType())
                .currency(accountDto.getCurrency())
                .build();
        BankAccount bankAccount1 = bankAccountRepository.save(bankAccount);
        BankAccountRespondeDto bankAccountRespondeDto= accountMapper.fromBankAccount(bankAccount);
        return bankAccountRespondeDto;
    }
@Override
public BankAccountRespondeDto updateAccount(String id, BankAccountRequestDto accountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .creatDate(new Date())
                .balance(accountDto.getBalance())
                .type(accountDto.getType())
                .currency(accountDto.getCurrency())
                .build();
        BankAccount bankAccount1 = bankAccountRepository.save(bankAccount);
        BankAccountRespondeDto bankAccountRespondeDto= accountMapper.fromBankAccount(bankAccount);
        return bankAccountRespondeDto;
}
}
