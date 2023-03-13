package com.highandbrightdev.bank;

import java.util.Set;

public class GroupDepositAccount {
    private Set<Member> owners;
    private int balance;

    public GroupDepositAccount(Set<Member> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "GroupDepositAccount[owners=" + owners + "]";
    }

    public boolean isOwnedBy(Member owner) {
        return this.owners.contains(owner);
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
