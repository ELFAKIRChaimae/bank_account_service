package org.sid.bank_account_service.Reposotories;

import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
