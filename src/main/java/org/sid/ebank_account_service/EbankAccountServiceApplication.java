package org.sid.ebank_account_service;

import org.sid.ebank_account_service.entities.BankAccount;
import org.sid.ebank_account_service.enums.AccountType;
import org.sid.ebank_account_service.repositories.BankAccountRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepositorie bankAccountRepositorie) {
		return args -> {
			for(int i=0; i<10; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5?AccountType.CURRENT_ACCOUNT:AccountType.SAVINGS_ACCOUNT)
						.balance(1000+Math.random()*9000)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				bankAccountRepositorie.save(bankAccount);
			}
		};
	}

}
