package org.sid.ebank_account_service.web;

import org.sid.ebank_account_service.dto.BankAcountRequestDto;
import org.sid.ebank_account_service.dto.BankAcountResponseDto;
import org.sid.ebank_account_service.entities.BankAccount;
import org.sid.ebank_account_service.repositories.BankAccountRepositorie;
import org.sid.ebank_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepositorie bankAccountRepositorie;
    private AccountService accountService;

    public AccountRestController(BankAccountRepositorie bankAccountRepositorie) {
        this.bankAccountRepositorie = bankAccountRepositorie;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bakAccounts(){
        return bankAccountRepositorie.findAll();
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccount bakAccount(@PathVariable String id){
        return bankAccountRepositorie.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @PostMapping("/bankAccount")
    public BankAcountResponseDto save(@RequestBody BankAcountRequestDto requestDto ){
        return  accountService.addAccount(requestDto);
    }
//    public BankAccount save(@RequestBody BankAccount bankAccount){
//        bankAccount.setId(UUID.randomUUID().toString());
//        bankAccount.setCreatedAt(new Date());
//        return bankAccountRepositorie.save(bankAccount);
//    }

    @PutMapping("/bankAccount/{id}")
    public BankAccount UpAccount(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepositorie.findById(id).orElseThrow();
        if(account.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(account.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if(account.getType()!=null) account.setType(bankAccount.getType());
        if(account.getCreatedAt()!=null) account.setCreatedAt(new Date());
        return bankAccountRepositorie.save(account);
    }

    @DeleteMapping("/bankAccount/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepositorie.deleteById(id);
    }
}
