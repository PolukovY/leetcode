package com.levik.leetcode.timeBasedKeyValueStore;

import java.util.*;

public class TimeMap2 {

    private final Map<String, TreeMap<Integer, String>> storage;

    public TimeMap2() {
        this.storage = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> values = storage.getOrDefault(key, new TreeMap<>());
        values.put(timestamp, value);
        storage.put(key, values);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> values = storage.getOrDefault(key, new TreeMap<>());
        Map.Entry<Integer, String> lowerKey = values.lowerEntry(timestamp + 1);

        if (lowerKey == null) {
            return "";
        }

        return lowerKey.getValue();
    }
}
