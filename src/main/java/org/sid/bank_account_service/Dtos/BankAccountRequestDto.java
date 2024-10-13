package org.sid.bank_account_service.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.enums.AccountType;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDto {
        private Double balance ;
        private String currency ;
        private AccountType type ;
    }

