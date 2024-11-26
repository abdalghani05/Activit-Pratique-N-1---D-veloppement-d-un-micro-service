package org.sid.ebank_account_service.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebank_account_service.enums.AccountType;

import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAcountRequestDto {
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
