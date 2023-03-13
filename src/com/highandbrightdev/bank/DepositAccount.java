package com.highandbrightdev.bank;

public class zㅋㅌㄴㄴㄴㄴㄴㅋㅋDepositAccount {
    private Member owner;
    private int balance;
    public DepositAccount(Member owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "DepositAccount[owner=" + owner + "]";
    }

    public boolean isOwnedBy(Member owner) {
        return this.owner == owner;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
