package org.sid.bank_account_service.web;

import org.sid.bank_account_service.Dtos.BankAccountRequestDto;
import org.sid.bank_account_service.Dtos.BankAccountRespondeDto;
import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Reposotories.BankAccountRepository;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.sid.bank_account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

public class AccountRestController {
    private BankAccountRepository bankAccountRepo;
    private AccountService accountService;
    private AccountMapper accountMapper;
    @Autowired

    public AccountRestController(AccountMapper accountMapper, AccountService accountService, BankAccountRepository bankAccountRepo) {
        this.accountMapper = accountMapper;
        this.accountService = accountService;
        this.bankAccountRepo = bankAccountRepo;
    }

    public AccountRestController(BankAccountRepository bankAccountRepo) {

        this.bankAccountRepo = bankAccountRepo;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepo.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount BankAccount(@PathVariable String id) {
        return bankAccountRepo.findById(id).orElseThrow(()->new RuntimeException(String.format("% s Not found ",id))) ;
    }

    @PostMapping("/bankAccounts")
    public BankAccountRespondeDto save(@RequestBody BankAccountRequestDto bankAccountDto) {
        return  accountService.addAccount(bankAccountDto);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id ,@RequestBody BankAccount bankAccount) {
       BankAccount account=bankAccountRepo.findById(id).orElse(null);
       if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
       if (bankAccount.getCreatDate() != null) account.setCreatDate(bankAccount.getCreatDate());
       if (bankAccount.getType()!= null) account.setType(bankAccount.getType());
       if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
       return bankAccountRepo.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
          bankAccountRepo.deleteById(id);
    }


}
