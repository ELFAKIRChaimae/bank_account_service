package org.sid.bank_account_service.service;

import org.sid.bank_account_service.Dtos.BankAccountRequestDto;
import org.sid.bank_account_service.Dtos.BankAccountRespondeDto;
import org.sid.bank_account_service.Entities.BankAccount;

public interface AccountService {


    public BankAccountRespondeDto addAccount(BankAccountRequestDto accountDto);


    public BankAccountRespondeDto updateAccount(String id, BankAccountRequestDto accountDto);
}
