package org.sid.bank_account_service.mappers;


import org.sid.bank_account_service.Dtos.BankAccountRequestDto;
import org.sid.bank_account_service.Dtos.BankAccountRespondeDto;
import org.sid.bank_account_service.Entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
public BankAccountRespondeDto fromBankAccount(BankAccount bankAccount) {
    BankAccountRespondeDto bankAccountRespondeDto = new BankAccountRespondeDto();
    BeanUtils.copyProperties(bankAccount, bankAccountRespondeDto);
    return bankAccountRespondeDto;
}

public BankAccount toBankAccount(BankAccountRespondeDto bankAccountRespondeDto) {
    BankAccount bankAccount = new BankAccount();
    BeanUtils.copyProperties(bankAccountRespondeDto, bankAccount);
    return bankAccount;
}
public BankAccountRequestDto toBankAccountRequestDto(BankAccountRespondeDto bankAccountRespondeDto) {
    BankAccountRequestDto bankAccountRequestDto = new BankAccountRequestDto();
    BeanUtils.copyProperties(bankAccountRespondeDto, bankAccountRequestDto);
    return bankAccountRequestDto;
}

public BankAccount toBankAccount(BankAccountRequestDto bankAccountRequestDto) {
    BankAccount bankAccount = new BankAccount();
    BeanUtils.copyProperties(bankAccountRequestDto, bankAccount);
    return bankAccount;
}

}