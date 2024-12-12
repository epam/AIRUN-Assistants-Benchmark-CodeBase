package com.epam.aicode.java;

import java.math.BigDecimal;
import java.util.Date;

public class Transfer {
    private final String accountId;
    private final Date date;
    private final BigDecimal amount;

    public Transfer(String accountId, Date date, BigDecimal amount) {
        if (accountId == null || date == null || amount == null) {
            throw new IllegalArgumentException("cnanot accept null argument(s)");
        }
        this.accountId = accountId;
        this.date = date;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
