package org.sid.ebank_account_service.entities;

import org.sid.ebank_account_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = {BankAccount.class})
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
