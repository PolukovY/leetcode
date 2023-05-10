package com.levik.design.crud;

import java.util.*;

import static java.lang.System.*;
import static java.util.Comparator.comparing;
import static java.util.Objects.*;
import static java.util.Optional.*;

public class InMemoryItemWarehouse implements ItemsWarehouse<Account, String> {
    private static final String ACCOUNT_ID_NOT_FOUND = "Account [%s] not found";

    private final Map<String, Account> storage;
    private final List<Account> accountsInOrder;
    public final Identity<String> identity;

    public InMemoryItemWarehouse(Map<String, Account> storage, List<Account> accountsInOrder, Identity<String> identity) {
        this.storage = storage;
        this.identity = identity;
        this.accountsInOrder = accountsInOrder;
    }

    @Override
    public Account add(Account source) {
        if (isNull(source.getAccountId())) {
            String newAccountId = identity.generate();
            save(source, newAccountId);
            return source;
        }

        var target = storage.get(source.getAccountId());

        if (isNull(target)) {
            throw new IllegalArgumentException(String.format(ACCOUNT_ID_NOT_FOUND, source.getAccountId()));
        }

        var updatedAccount = new Account(source.getName(), source.getDescription());
        String existingAccountId = target.getAccountId();
        save(updatedAccount, existingAccountId);

        return updatedAccount;
    }

    @Override
    public Optional<Account> finaById(String id) {
        return ofNullable(storage.get(id));
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int pageNum = pageable.getPageNum();
        int startIndex = pageSize * (pageNum - 1);
        int endIndex = Math.min(startIndex + pageSize, accountsInOrder.size());
        var pagedAccountList = new ArrayList<>(accountsInOrder.subList(startIndex, endIndex));
        return new Page<>(pagedAccountList, accountsInOrder.size(), pageSize, pageNum, currentTimeMillis());
    }

    @Override
    public void delete(String id) {
        var removeAccount = storage.remove(id);
        if (nonNull(removeAccount)) {
            accountsInOrder.remove(removeAccount);
        }
    }

    private void sortAccountsInOrder() {
        accountsInOrder.sort(comparing(Account::getName).thenComparing(Account::getUpdatedAt));
    }

    private void save(Account source, String identity) {
        source.setAccountId(identity);
        storage.put(source.getAccountId(), source);
        accountsInOrder.add(source);
        sortAccountsInOrder();
    }
}
