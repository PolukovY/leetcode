package com.levik.design.chat.custome.chat.persistent;

import com.levik.design.chat.custome.chat.model.Message;

import java.util.*;

public class TTLLinkedHashMap extends LinkedHashMap<String, Message> {
    private final long ttl; // Time-to-live in milliseconds
    private final int limit;

    public TTLLinkedHashMap(int maxElements, long ttl) {
        super(maxElements, 0.75f, true);
        this.ttl = ttl;
        this.limit = maxElements;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Message> eldest) {
        return System.currentTimeMillis() - eldest.getValue().createAt() > ttl || this.size() > limit;
    }

    @Override
    public Message put(String key, Message value) {
        return this.put(key, value);
    }
}

