package com.levik.design.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.lang.String.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InMemoryItemWarehouseTest {

    private static final String DEFAULT_NAME = "Default name_%s";
    private static final String DEFAULT_DESCRIPTION = "Default description_%s";
    
    private ItemsWarehouse<Account, String> testInstance;

    @BeforeEach
    void setUp() {
        Map<String, Account> storage = new HashMap<>();
        List<Account> accountsInOrder = new ArrayList<>();
        Identity<String> identity = new UUIDIdentity();
        testInstance = new InMemoryItemWarehouse(storage, accountsInOrder, identity);
    }

    @Test
    void shouldAddAndGet() {
        //given
        var newAccount = new Account(format(DEFAULT_NAME, 1), format(DEFAULT_DESCRIPTION, 1));
        //when
        Account savedAccount  = testInstance.add(newAccount);
        //then

        Optional<Account> account = testInstance.finaById(savedAccount.getAccountId());

        assertThat(account.isPresent()).isTrue();
        account.ifPresent(value -> assertThat(value).isEqualTo(savedAccount));
    }

    @Test
    void shouldNotFindIdThatNotExist() {
        //given
        var newAccount = new Account(format(DEFAULT_NAME, 1), format(DEFAULT_DESCRIPTION, 1));
        testInstance.add(newAccount);

        //when
        Optional<Account> account = testInstance.finaById("NotExistingId");

        //then
        assertThat(account.isPresent()).isFalse();
    }

    @Test
    void shouldDeleteExistingId() {
        //given
        var newAccount = new Account(format(DEFAULT_NAME, 1), format(DEFAULT_DESCRIPTION, 1));
        Account savedAccount = testInstance.add(newAccount);

        Optional<Account> account = testInstance.finaById(savedAccount.getAccountId());
        assertThat(account.isPresent()).isTrue();

        //when
        testInstance.delete(savedAccount.getAccountId());

        //then
        Optional<Account> checkIfAccountExist = testInstance.finaById(savedAccount.getAccountId());
        assertThat(checkIfAccountExist.isPresent()).isFalse();
    }
}