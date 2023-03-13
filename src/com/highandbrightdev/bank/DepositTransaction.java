package com.highandbrightdev.bank;

import java.time.LocalDateTime;

public class DepositTransaction {
    DepositAccount depositAccount;
    int amount;
    final LocalDateTime createdAt = LocalDateTime.now();

    public DepositTransaction(DepositAccount depositAccount, int amount) {
        this.depositAccount = depositAccount;
        this.amount = amount;
    }

    public boolean isGeneratedBy(DepositAccount depositAccount) {
        return depositAccount == depositAccount;
    }

    @Override
    public String toString() {
        return "Deposit " + amount + " $ to " + depositAccount + " at " + PrettyPrinter.exactTime(createdAt);
    }
}
