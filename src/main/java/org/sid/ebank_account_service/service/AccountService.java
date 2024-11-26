package org.sid.ebank_account_service.service;

import org.sid.ebank_account_service.dto.BankAcountRequestDto;
import org.sid.ebank_account_service.dto.BankAcountResponseDto;

public interface AccountService {
    public BankAcountResponseDto addAccount(BankAcountRequestDto bankAcountRequestDto);
}
