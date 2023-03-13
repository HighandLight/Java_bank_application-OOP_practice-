package com.highandbrightdev.bank;

import java.time.LocalDateTime;

public class WithdrawalTransaction {
    DepositAccount depositAccount;
    int amount;
    final LocalDateTime createdAt = LocalDateTime.now();

    public WithdrawalTransaction(DepositAccount depositAccount, int amount) {
        this.depositAccount = depositAccount;
        this.amount = amount;
    }

    public boolean isGeneratedBy(DepositAccount depositAccount) {
        return depositAccount == depositAccount;
    }

    @Override
    public String toString() {
        return "Withdraw " + amount + " $ from " + depositAccount + " at " + PrettyPrinter.exactTime(createdAt);
    }
}
