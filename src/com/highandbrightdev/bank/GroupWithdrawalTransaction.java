package com.highandbrightdev.bank;

import java.time.LocalDateTime;

public class GroupWithdrawalTransaction {
    GroupDepositAccount groupDepositAccount;
    int amount;
    final LocalDateTime createdAt = LocalDateTime.now();

    public GroupWithdrawalTransaction(GroupDepositAccount groupDepositAccount, int amount) {
        this.groupDepositAccount = groupDepositAccount;
        this.amount = amount;
    }

    public boolean isGeneratedBy(GroupDepositAccount groupDepositAccount) {
        return this.groupDepositAccount == groupDepositAccount;
    }

    @Override
    public String toString() {
        return "Withdraw " + amount + " $ from " + groupDepositAccount + " at " + PrettyPrinter.exactTime(createdAt);
    }
}
