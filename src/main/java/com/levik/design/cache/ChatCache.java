package com.levik.design.cache;

import java.util.List;
import java.util.Map;

public class ChatCache<K, T extends TimeMarker> {

    private final Map<K, CircularArrayList<T>> storage;

    private final int initialCapacity;
    private final long expiredTimeMinutes;

    public ChatCache(Map<K, CircularArrayList<T>> storage, int initialCapacity, long expiredTimeMinutes) {
        this.storage = storage;
        this.initialCapacity = initialCapacity;
        this.expiredTimeMinutes = expiredTimeMinutes;
    }

    public void add(K key, T val) {
        CircularArrayList<T> values = storage.getOrDefault(key, new CircularArrayList<>(initialCapacity, expiredTimeMinutes));
        values.add(val);
    }

    public List<T> get(K key) {
        CircularArrayList<T> orDefault = storage.getOrDefault(key, new CircularArrayList<>(initialCapacity, expiredTimeMinutes));
        return orDefault.getAll();
    }

    public void remove(K key) {
        storage.remove(key);
    }

    @Override
    public String toString() {
        return "ChatCache{" +
                "storage=" + storage +
                '}';
    }
}
