package com.highandbrightdev.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Bank {
    /**
     * ##### Members #####
     */
    private List<Member> members = new ArrayList<>();

    /**
     * ##### Accounts #####
     */
    private List<DepositAccount> depositAccounts = new ArrayList<>();
    private List<GroupDepositAccount> groupDepositAccounts = new ArrayList<>();

    /**
     * ##### Transactions #####
     */
    private List<DepositTransaction> depositTransactions = new ArrayList<>();
    private List<GroupDepositTransaction> groupDepositTransactions = new ArrayList<>();
    private List<WithdrawalTransaction> withdrawalTransactions = new ArrayList<>();
    private List<GroupWithdrawalTransaction> groupWithdrawalTransactions = new ArrayList<>();

    public Member registerMember(String name) {
        System.out.println("registerMember name: " + name);
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public void showAllMembers() {
        System.out.println("Show all members");
        PrettyPrinter.doubleLines(10);
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public DepositAccount createDepositAccount(Member owner) {
        System.out.println("createDepositAccount owner: " + owner);
        DepositAccount depositAccount = new DepositAccount(owner);
        depositAccounts.add(depositAccount);
        return depositAccount;
    }

    public GroupDepositAccount createGroupDepositAccount(Set<Member> owners) {
        System.out.println("createGroupDepositAccount owners: " + owners);
        GroupDepositAccount groupDepositAccount = new GroupDepositAccount(owners);
        groupDepositAccounts.add(groupDepositAccount);
        return groupDepositAccount;
    }

    public void showAllAccounts() {
        System.out.println("showAllAccounts");
        System.out.println("Deposit accounts");
        PrettyPrinter.doubleLines(10);
        for (DepositAccount depositAccount : depositAccounts) {
            System.out.println(depositAccount);
        }

        System.out.println("Group Deposit accounts");
        PrettyPrinter.doubleLines(10);

        for (GroupDepositAccount groupDepositAccount : groupDepositAccounts) {
            System.out.println(groupDepositAccount);
        }
    }

    public void showAccountDetail(DepositAccount depositAccount) {
        System.out.println("showAccountDetail");
        PrettyPrinter.doubleLines(10);
        System.out.println(depositAccount);
    }

    public void showAccountDetail(GroupDepositAccount groupDepositAccount) {
        System.out.println("showAccountDetail");
        PrettyPrinter.doubleLines(10);
        System.out.println(groupDepositAccount);
    }

    public void showAllAccounts(Member owner) {
        System.out.println("showAllAccounts owned by " + owner);
        PrettyPrinter.doubleLines(10);
        for (DepositAccount depositAccount : depositAccounts) {
            if (depositAccount.isOwnedBy(owner)) {
                System.out.println(depositAccount);
            }
        }

        for (GroupDepositAccount groupDepositAccount : groupDepositAccounts) {
            if (groupDepositAccount.isOwnedBy(owner)) {
                System.out.println(groupDepositAccount);
            }
        }
    }

    public DepositTransaction deposit(DepositAccount depositAccount, int amount) throws InterruptedException {
        System.out.println("Deposit " + amount + " $ to " + depositAccount);
        depositAccount.deposit(amount);
        DepositTransaction depositTransaction = new DepositTransaction(depositAccount, amount);
        depositTransactions.add(depositTransaction);
        Thread.sleep(10);
        return depositTransaction;
    }
    public GroupDepositTransaction deposit(GroupDepositAccount groupDepositAccount, int amount) throws InterruptedException {
        System.out.println("Deposit " + amount + " $ to " + groupDepositAccount);
        groupDepositAccount.deposit(amount);
        GroupDepositTransaction groupDepositTransaction = new GroupDepositTransaction(groupDepositAccount, amount);
        groupDepositTransactions.add(groupDepositTransaction);
        Thread.sleep(10);
        return groupDepositTransaction;
    }

    public WithdrawalTransaction withdraw(DepositAccount depositAccount, int amount) throws InterruptedException {
        System.out.println("Withdraw " + amount + " $ from " + depositAccount);
        depositAccount.withdraw(amount);
        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(depositAccount, amount);
        withdrawalTransactions.add(withdrawalTransaction);
        Thread.sleep(10);
        return withdrawalTransaction;
    }

    public GroupWithdrawalTransaction withdraw(GroupDepositAccount groupDepositAccount, int amount) throws InterruptedException {
        System.out.println("Withdraw " + amount + " $ from " + groupDepositAccount);
        groupDepositAccount.withdraw(amount);
        GroupWithdrawalTransaction groupWithdrawalTransaction = new GroupWithdrawalTransaction(groupDepositAccount, amount);
        groupWithdrawalTransactions.add(groupWithdrawalTransaction);
        Thread.sleep(10);
        return groupWithdrawalTransaction;
    }

    public void showAccountTransactionHistory(DepositAccount depositAccount) {
        System.out.println("showAccountTransactionHistory of " + depositAccount);
        PrettyPrinter.doubleLines(10);

        List<DepositTransaction> myGroupDepositTransactions = new ArrayList<>();
        List<WithdrawalTransaction> myGroupWithdrawalTransactions = new ArrayList<>();

        for (DepositTransaction depositTransaction : depositTransactions) {
            if (depositTransaction.isGeneratedBy(depositAccount)) {
                myGroupDepositTransactions.add(depositTransaction);
            }
        }

        for (WithdrawalTransaction withdrawalTransaction : withdrawalTransactions) {
            if (withdrawalTransaction.isGeneratedBy(depositAccount)) {
                myGroupWithdrawalTransactions.add(withdrawalTransaction);
            }
        }

        int depositIndex = 0;
        int withdrawalIndex = 0;

        while (depositIndex < myGroupDepositTransactions.size() || withdrawalIndex < myGroupWithdrawalTransactions.size()) {
            if (depositIndex == myGroupDepositTransactions.size()) {
                System.out.println(myGroupWithdrawalTransactions.get(withdrawalIndex++));
            } else if (withdrawalIndex == myGroupWithdrawalTransactions.size()) {
                System.out.println(myGroupDepositTransactions.get(depositIndex++));
            } else {
                WithdrawalTransaction withdrawalTransaction = myGroupWithdrawalTransactions.get(withdrawalIndex);
                DepositTransaction depositTransaction = myGroupDepositTransactions.get(depositIndex);

                if (withdrawalTransaction.createdAt.isBefore(depositTransaction.createdAt)) {
                    System.out.println(withdrawalTransaction);
                    withdrawalIndex += 1;
                } else {
                    System.out.println(depositTransaction);
                    depositIndex += 1;
                }
            }
        }
    }

    public void showAccountTransactionHistory(GroupDepositAccount groupDepositAccount) {
        System.out.println("showAccountTransactionHistory of " + groupDepositAccount);
        PrettyPrinter.doubleLines(10);

        List<GroupDepositTransaction> myGroupDepositTransactions = new ArrayList<>();
        List<GroupWithdrawalTransaction> myGroupWithdrawalTransactions = new ArrayList<>();

        for (GroupDepositTransaction groupDepositTransaction : groupDepositTransactions) {
            if (groupDepositTransaction.isGeneratedBy(groupDepositAccount)) {
                myGroupDepositTransactions.add(groupDepositTransaction);
            }
        }

        for (GroupWithdrawalTransaction groupWithdrawalTransaction : groupWithdrawalTransactions) {
            if (groupWithdrawalTransaction.isGeneratedBy(groupDepositAccount)) {
                myGroupWithdrawalTransactions.add(groupWithdrawalTransaction);
            }
        }


        int depositIndex = 0;
        int withdrawalIndex = 0;

        while (depositIndex < myGroupDepositTransactions.size() || withdrawalIndex < myGroupWithdrawalTransactions.size()) {
            if (depositIndex == myGroupDepositTransactions.size()) {
                System.out.println(myGroupWithdrawalTransactions.get(withdrawalIndex++));
            } else if (withdrawalIndex == myGroupWithdrawalTransactions.size()) {
                System.out.println(myGroupDepositTransactions.get(depositIndex++));
            } else {
                GroupWithdrawalTransaction groupWithdrawalTransaction = myGroupWithdrawalTransactions.get(withdrawalIndex);
                GroupDepositTransaction groupDepositTransaction = myGroupDepositTransactions.get(depositIndex);

                if (groupDepositTransaction.createdAt.isBefore(groupDepositTransaction.createdAt)) {
                    System.out.println(groupWithdrawalTransaction);
                    withdrawalIndex += 1;
                } else {
                    System.out.println(groupDepositTransaction);
                    depositIndex += 1;
                }
            }
        }
    }
}
