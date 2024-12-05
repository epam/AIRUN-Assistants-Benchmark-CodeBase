package com.epam.aicode.java;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Account {

    private final String accountId;
    private BigDecimal currentAmount;
    private Date updateDate;

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, currentAmount, updateDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        return Objects.equals(accountId, other.accountId) && Objects.equals(currentAmount, other.currentAmount)
                && Objects.equals(updateDate, other.updateDate);
    }
}
