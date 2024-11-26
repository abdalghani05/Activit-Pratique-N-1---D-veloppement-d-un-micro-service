package org.sid.ebank_account_service.service;

import org.sid.ebank_account_service.dto.BankAcountRequestDto;
import org.sid.ebank_account_service.dto.BankAcountResponseDto;
import org.sid.ebank_account_service.entities.BankAccount;
import org.sid.ebank_account_service.repositories.BankAccountRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepositorie bankAccountRepositories;
    @Override
    public BankAcountResponseDto addAccount(BankAcountRequestDto bankAcountRequestDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAcountRequestDto.getBalance())
                .currency(bankAcountRequestDto.getCurrency())
                .type(bankAcountRequestDto.getType())
                .build();
        BankAccount saveBankAccount = bankAccountRepositories.save(bankAccount);
        BankAcountResponseDto bankAcountResponseDto = BankAcountResponseDto.builder()
                .id(saveBankAccount.getId())
                .createdAt(saveBankAccount.getCreatedAt())
                .balance(saveBankAccount.getBalance())
                .currency(saveBankAccount.getCurrency())
                .type(saveBankAccount.getType())
                .build();
        return bankAcountResponseDto;
    }
}
