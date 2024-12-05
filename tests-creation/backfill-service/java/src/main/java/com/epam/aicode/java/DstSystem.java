package com.epam.aicode.java;

public interface DstSystem {

    Account getAccount(String accountId);

    void createAccount(Account account);

    void updateAccount(Account account);
}
