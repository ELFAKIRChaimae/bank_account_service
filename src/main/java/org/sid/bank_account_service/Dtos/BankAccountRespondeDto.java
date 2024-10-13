package org.sid.bank_account_service.Dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.sid.bank_account_service.enums.AccountType;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRespondeDto {
    private String id ;
    private Date creatDate ;
    private Double balance ;
    private String currency ;
    private AccountType type ;




}
