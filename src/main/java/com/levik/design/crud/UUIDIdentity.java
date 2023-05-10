package com.levik.design.crud;

import java.util.UUID;

public class UUIDIdentity implements Identity<String> {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
