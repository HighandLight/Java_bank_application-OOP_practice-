package com.highandbrightdev.bank;


import java.util.HashSet;

/**
 *  1. Bank에 다 때려넣기.
 *
 * overriding
 * overloading
 *
 * [x] registerMember
 * [x] showAllMembers
 * [x] createDepositAccount
 * [x] createGroupDepositAccount
 * [x] showAllAccounts()
 * [x] showAccountDetail(Account)
 * [x] showAllMemberAccount(member)
 * [x] deposit
 * [x] withdrawal
 * [x] showAccountTransactionHistory
 *  2. Generatization of account
 */

public class BankApplication {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Member patrick = bank.registerMember("Patrick");
        Member kyle = bank.registerMember("Kyle");
        Member rachel = bank.registerMember("Rachel");

        bank.showAllMembers();

        DepositAccount kyleDepositAccount = bank.createDepositAccount(kyle);

        HashSet<Member> family = new HashSet<>();
        family.add(kyle);
        family.add(patrick);
        family.add(rachel);
        GroupDepositAccount familyGroupDepositAccount = bank.createGroupDepositAccount(family);

        bank.showAllAccounts();

        bank.showAccountDetail(kyleDepositAccount);
        bank.showAccountDetail(familyGroupDepositAccount);

        bank.showAllAccounts(kyle);
        bank.showAllAccounts(patrick);
        bank.showAllAccounts(rachel);

        bank.deposit(kyleDepositAccount, 100);
        bank.deposit(familyGroupDepositAccount, 1_000_000_000);

        bank.withdraw(kyleDepositAccount, 100);
        bank.withdraw(familyGroupDepositAccount, 1_000_000);

//        bank.showAccountTransactionHistory(familyGroupDepositAccount);

//        bank.deposit(kyleDepositAccount, 30);
//        bank.deposit(kyleDepositAccount, 40);
//        bank.withdraw(kyleDepositAccount, 30);
//        bank.deposit(kyleDepositAccount, 50);
//        bank.deposit(kyleDepositAccount, 60);
//        bank.withdraw(kyleDepositAccount, 30);
//        bank.deposit(kyleDepositAccount, 70);
//        bank.deposit(kyleDepositAccount, 80);
//        bank.withdraw(kyleDepositAccount, 30);
//        bank.deposit(kyleDepositAccount, 90);
//        bank.withdraw(kyleDepositAccount, 30);

        bank.showAccountTransactionHistory(kyleDepositAccount);
        bank.showAccountTransactionHistory(familyGroupDepositAccount);
    }
}
