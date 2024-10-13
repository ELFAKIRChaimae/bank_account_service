package org.sid.bank_account_service;

import org.sid.bank_account_service.Entities.BankAccount;
import org.sid.bank_account_service.Entities.Customer;
import org.sid.bank_account_service.Reposotories.BankAccountRepository;
import org.sid.bank_account_service.Reposotories.CustomerRepository;
import org.sid.bank_account_service.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository , CustomerRepository customerRepository) {
		return args -> {
			Stream.of("hanae","chaimae","aya","nour").forEach(c-> {
						Customer customer = Customer.builder()
								.name(c)
								.build();
						customerRepository.save(customer);

					}
			);
			customerRepository.findAll().forEach(customer->{
				    for (int i = 0; i < 10; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString().toString())
							.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.balance(10000+Math.random()*10000)
							.creatDate(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
					}
					});

				};
		};
	}

