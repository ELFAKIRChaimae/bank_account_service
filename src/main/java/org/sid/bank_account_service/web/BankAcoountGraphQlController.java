package org.sid.bank_account_service.web;

import org.sid.bank_account_service.Dtos.BankAccountRequestDto;
import org.sid.bank_account_service.Dtos.BankAccountRespondeDto;
import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Entities.Customer;
import org.sid.bank_account_service.Reposotories.BankAccountRepository;
import org.sid.bank_account_service.Reposotories.CustomerRepository;
import org.sid.bank_account_service.service.AccountService;
import org.sid.bank_account_service.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAcoountGraphQlController {


private BankAccountRepository bankAccountRepository;
@Autowired
private CustomerRepository customerRepository;

private AccountService accountService;

    public BankAcoountGraphQlController(AccountService accountService, BankAccountRepository bankAccountRepository) {
        this.accountService = accountService;
        this.bankAccountRepository = bankAccountRepository;
    }

    @QueryMapping
public List<BankAccount> accountList(){
    return bankAccountRepository.findAll();
}

@QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format(" account %s not found", id)));
    }

@MutationMapping
   public BankAccountRespondeDto addAccount(@Argument BankAccountRequestDto bankAccount) {
       return accountService.addAccount(bankAccount);  // Ensure it returns 'BankAccount'
   }

@MutationMapping
public BankAccountRespondeDto updatdeAccount(@Argument String id ,@Argument BankAccountRequestDto bankAccount) {
        return accountService.updateAccount(id,bankAccount);  // Ensure it returns 'BankAccount'
    }

@MutationMapping
public Boolean deleteAccount(@Argument String id) {
     bankAccountRepository.deleteById(id);
     return true ; // Ensure it returns 'BankAccount'
    }
 @QueryMapping
    public  List<Customer> customers(){

        return customerRepository.findAll();
 }


}




