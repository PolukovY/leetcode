package com.levik.design.crud;

import java.util.Objects;

public class Account {

    private String accountId;
    private final String name;
    private final String description;

    private long createAt;
    private final long updatedAt;


    public Account(String name, String description) {
        this.name = name;
        this.description = description;
        this.updatedAt = System.currentTimeMillis();
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
        this.createAt = System.currentTimeMillis();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(name, account.name) && Objects.equals(description, account.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, name, description);
    }

    public long getCreateAt() {
        return createAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
