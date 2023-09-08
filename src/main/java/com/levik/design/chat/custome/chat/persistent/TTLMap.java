package com.levik.design.chat.custome.chat.persistent;

import java.util.LinkedHashMap;
import java.util.Map;

public class TTLMap<K, V extends TimeMarker> extends LinkedHashMap<K, V>{

    private final int limit;
    private final int ttl; // Time-to-live in milliseconds
    private final TimeMarker timeMarker;

    public TTLMap(int limit, int ttl, TimeMarker timeMarker) {
        super(limit, 0.75f, true);
        this.limit = limit;
        this.ttl = ttl;
        this.timeMarker = timeMarker;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        long currentTimeToLive = timeMarker.getTime() - eldest.getValue().getTime();
        return this.size() > limit || currentTimeToLive > ttl;
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public V get(Object key) {
        V val = super.get(key);
        long currentTimeToLive = timeMarker.getTime() - val.getTime();
        return currentTimeToLive < ttl ? val : null;
    }
}
