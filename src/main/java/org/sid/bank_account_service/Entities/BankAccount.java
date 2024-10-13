package org.sid.bank_account_service.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.enums.AccountType;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id ;
    private Date creatDate ;
    private Double balance ;
    private String currency ;
    @Enumerated(EnumType.STRING)
    private AccountType type ;
    @ManyToOne
    private Customer customer ;

}
