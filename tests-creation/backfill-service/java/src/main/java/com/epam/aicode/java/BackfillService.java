package com.epam.aicode.java;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackfillService {
    private final SrcSystem srcSystem;
    private final DstSystem dstSystem;

    public BackfillService(SrcSystem srcSystem, DstSystem dstSystem) {
        this.srcSystem = srcSystem;
        this.dstSystem = dstSystem;
    }

    public void backfill() {
        Map<String, Account> accounts = new HashMap<>();

        List<Transfer> transfers = srcSystem.getTransfers();
        for (Transfer transfer : transfers) {
            String accountId = transfer.getAccountId();
            Account account = accounts.get(accountId);
            if (account == null) {
                account = new Account(accountId, transfer.getAmount(), transfer.getDate());
                accounts.put(accountId, account);
            }
            else
            {
                account.setCurrentAmount(account.getCurrentAmount().add(transfer.getAmount()));
                Date updateDate = account.getUpdateDate();
                Date transferDate = transfer.getDate();
                if (updateDate.before(transferDate)) {
                    account.setUpdateDate(transferDate);
                }
            }
        }

        for (Account account : accounts.values()) {
            Account dstAccount = dstSystem.getAccount(account.getAccountId());
            if (dstAccount == null) {
                dstSystem.createAccount(account);
            } else {
                if (!dstAccount.equals(account)) {
                    dstSystem.updateAccount(account);
                }
            }
        }
    }
}
